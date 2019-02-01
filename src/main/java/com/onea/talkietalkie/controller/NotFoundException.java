package com.onea.talkietalkie.controllers;

class NotFoundException extends RuntimeException {

	NotFoundException(Long id) {
		super("Could not find " + id);
	}
}