package com.onea.talkietalkie.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public @Data class User {
    @Id
    public Integer id;
    public Integer name;
}