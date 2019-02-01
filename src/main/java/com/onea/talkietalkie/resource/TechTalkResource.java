package com.onea.talkietalkie.resource;

import org.springframework.hateoas.ResourceSupport;

import com.onea.talkietalkie.model.TechTalk;

public class TechTalkResource extends ResourceSupport {
	private String title;
	private Long id;
	public TechTalkResource(TechTalk techTalk) {
		this.title=techTalk.getTitle();
		this.id = techTalk.getId();
	}

}
