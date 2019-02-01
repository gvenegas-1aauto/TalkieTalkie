package com.onea.talkietalkie.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onea.talkietalkie.model.TechTalk;
import com.onea.talkietalkie.repository.TechTalkRepository;


@RestController
class TechTalkController {

	private final TechTalkRepository repository;

	TechTalkController(TechTalkRepository repository) {
		this.repository = repository;
	}

	@GetMapping("talks")
	List<TechTalk> listAllTalks() {
		return repository.findAll();
	}

	@PostMapping("/newTalk")
	TechTalk newTechTalk(@RequestBody TechTalk newTechTalk) {
		return repository.save(newTechTalk);
	}

	@GetMapping("/talk/{id}")
	TechTalk listOneTalk(@PathVariable Long idTechTalk) {

		return repository.findById(idTechTalk)
			.orElseThrow(() -> new NotFoundException(idTechTalk));
	}

	@PutMapping("/updateTalk/{id}")
	TechTalk updateTechTalk(@RequestBody TechTalk newTechTalk, @PathVariable Long idTechTalk) {

		return repository.findById(idTechTalk)
			.map(techTalk -> {
				techTalk.setTitle(newTechTalk.getTitle());
				techTalk.setTalkDate(newTechTalk.getTalkDate());
				return repository.save(techTalk);
			})
			.orElseGet(() -> {
				newTechTalk.setId(idTechTalk);
				return repository.save(newTechTalk);
			});
	}

	@DeleteMapping("/deleteTalk/{id}")
	void deleteTechTalk(@PathVariable Long idTechTalk) {
		repository.deleteById(idTechTalk);
	}
}
