package com.onea.talkietalkie.controller;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 920395762323404896L;

	public NotFoundException(Long id) {
		super("Could not find " + id);
	}
}