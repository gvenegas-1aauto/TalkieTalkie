package com.onea.talkietalkie.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onea.talkietalkie.model.Rates;
import com.onea.talkietalkie.model.TechTalk;
import com.onea.talkietalkie.repository.RatesRepository;


@RestController
class RatesController {

	private final RatesRepository repository;

	RatesController(RatesRepository repository) {
		this.repository = repository;
	}

	@GetMapping("rates")
	List<Rates> listAllRates() {
		return repository.findAll();
	}

	@PostMapping("/newRate")
	Rates newRate(@RequestBody Rates newRate) {
		return repository.save(newRate);
	}

	@GetMapping("/rate/{id}")
	Rates listOneRate(@PathVariable Long idRate) {

		return repository.findById(idRate)
			.orElseThrow(() -> new NotFoundException(idRate));
	}
	
	@GetMapping("/talk/{idTalk}/user/{idUser}/rate/{idRate}")
	Rates listTalkUserRate(@PathVariable Long idTalk, @PathVariable Long idUser, @PathVariable Long idRate) {

		return repository.findById(idTalk)
			.orElseThrow(() -> new NotFoundException(idTalk));
	}

	@PutMapping("/updateRate/{id}")
	Rates updateRate(@RequestBody Rates newRate, @PathVariable Long idRate) {

		return repository.findById(idRate)
			.map(rate -> {
				rate.setRating(newRate.getRating());
				rate.setReason(newRate.getReason());
				return repository.save(rate);
			})
			.orElseGet(() -> {
				newRate.setId(idRate);
				return repository.save(newRate);
			});
	}

	@DeleteMapping("/deleteRate/{id}")
	void deleteRate(@PathVariable Long idRate) {
		repository.deleteById(idRate);
	}
}