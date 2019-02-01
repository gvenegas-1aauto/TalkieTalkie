package com.onea.talkietalkie.controller;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onea.talkietalkie.model.Presenter;
import com.onea.talkietalkie.repository.PresenterRepository;

@RestController
@RequestMapping(value="/presenter")
public class PresenterController {
	private PresenterRepository presenterRepository;
	@Inject
	public PresenterController(PresenterRepository presenterRepository) {
		this.presenterRepository=presenterRepository;
	}
	public Presenter getPresenter(@PathVariable("id") Long id) {
		Optional<Presenter> presenter = presenterRepository.findById(id);
		if(presenter.isPresent()) {
			return presenter.get();
		}
		return null;
	}

}
