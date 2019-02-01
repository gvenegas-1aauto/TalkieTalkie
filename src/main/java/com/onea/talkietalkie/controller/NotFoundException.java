package com.onea.talkietalkie.controller;

class NotFoundException extends RuntimeException {

	NotFoundException(Long id) {
		super("Could not find " + id);
	}
}