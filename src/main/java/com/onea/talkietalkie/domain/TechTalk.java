package com.onea.talkietalkie.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public @Data class TechTalk {
    @Id
    public Integer id;
    public Integer presenterId;
    public String Title;
    public Date talkDate;

}
