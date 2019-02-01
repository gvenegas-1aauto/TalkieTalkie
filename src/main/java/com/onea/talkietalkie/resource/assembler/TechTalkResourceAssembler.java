package com.onea.talkietalkie.resource.assembler;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.onea.talkietalkie.controller.PresenterController;
import com.onea.talkietalkie.controllers.TechTalkController;
import com.onea.talkietalkie.model.TechTalk;
import com.onea.talkietalkie.resource.Relations;
import com.onea.talkietalkie.resource.TechTalkResource;

@Component
public class TechTalkResourceAssembler extends ResourceAssemblerSupport<TechTalk, TechTalkResource> {

	public TechTalkResourceAssembler() {
		super(TechTalkController.class, TechTalkResource.class);
	}

	@Override
	public TechTalkResource toResource(TechTalk techTalk) {
		TechTalkResource resource = new TechTalkResource(techTalk);
		Link selfRelLink = ControllerLinkBuilder.linkTo(TechTalkController.class).slash(techTalk.getId()).withSelfRel();
		resource.add(selfRelLink);
		Link presenterRelLink = ControllerLinkBuilder.linkTo(PresenterController.class).slash(techTalk.getPresenter().getId()).withRel(Relations.WHO_PRESENTED_REL);
		resource.add(presenterRelLink);
		return resource;
	}
	

}
