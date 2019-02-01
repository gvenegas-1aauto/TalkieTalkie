package com.onea.talkietalkie.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onea.talkietalkie.model.TechTalk;
import com.onea.talkietalkie.repository.TechTalkRepository;
import com.onea.talkietalkie.resource.TechTalkResource;
import com.onea.talkietalkie.resource.assembler.TechTalkResourceAssembler;

@RestController
@RequestMapping(value = "/talk")
public class TechTalkController {

	private final TechTalkRepository talkRepository;
	private TechTalkResourceAssembler techTalkResourceAssembler;

	@Inject
	public TechTalkController(TechTalkRepository talkRepository, TechTalkResourceAssembler techTalkResourceAssembler) {
		this.talkRepository = talkRepository;
		this.techTalkResourceAssembler = techTalkResourceAssembler;
	}

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Collection<TechTalkResource> listAllTalks() {
		Collection<TechTalk> talks = talkRepository.findAll();
		Collection<TechTalkResource> resources = techTalkResourceAssembler.toResources(talks);
		return resources;
	}

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	List<TechTalk> saveTalk(@PathVariable("id") Long talkId, @RequestBody TechTalk talk) {
		talk = talkRepository.save(talk);
		return talkRepository.findAll();
	}

	@RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public TechTalkResource listOneTalk(@PathVariable("id") Long talkId) {
		Optional<TechTalk> talk = talkRepository.findById(talkId);
		if(!talk.isPresent()) {
			throw new NotFoundException(talkId);
		}
		TechTalkResource resource = techTalkResourceAssembler.toResource(talk.get());
		return resource;
	}

	@PutMapping("/updateTalk/{id}")
	TechTalk updateTechTalk(@RequestBody TechTalk newTechTalk, @PathVariable Long idTechTalk) {

		return talkRepository.findById(idTechTalk).map(techTalk -> {
			techTalk.setTitle(newTechTalk.getTitle());
			techTalk.setTalkDate(newTechTalk.getTalkDate());
			return talkRepository.save(techTalk);
		}).orElseGet(() -> {
			newTechTalk.setId(idTechTalk);
			return talkRepository.save(newTechTalk);
		});
	}

	@DeleteMapping("/deleteTalk/{id}")
	void deleteTechTalk(@PathVariable Long idTechTalk) {
		talkRepository.deleteById(idTechTalk);
	}
}
