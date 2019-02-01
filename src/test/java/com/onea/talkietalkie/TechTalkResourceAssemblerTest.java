package com.onea.talkietalkie;

import com.onea.talkietalkie.model.Presenter;
import com.onea.talkietalkie.model.TechTalk;
import com.onea.talkietalkie.resource.TechTalkResource;
import com.onea.talkietalkie.resource.assembler.TechTalkResourceAssembler;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TechTalkResourceAssemblerTest {
    private TechTalkResourceAssembler techTalkResourceAssembler;
    @Before
    public void init(){
        techTalkResourceAssembler = new TechTalkResourceAssembler();
    }

    @Test
    public void itShouldReturnResourceWithSelfRel(){
        TechTalk talk = new TechTalk();
        talk.setId(1L);
        talk.setTitle("this is my title");
        talk.setPresenter(new Presenter());
        TechTalkResource resource = techTalkResourceAssembler.toResource(talk);
        assertNotNull(resource.getLink("self"));

    }
}
