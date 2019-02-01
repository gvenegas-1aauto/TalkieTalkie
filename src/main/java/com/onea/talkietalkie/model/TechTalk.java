package com.onea.talkietalkie.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public @Data class TechTalk {
    @Id
    public Long id;
    public Integer presenterId;
    public String Title;
    public Date talkDate;

}
