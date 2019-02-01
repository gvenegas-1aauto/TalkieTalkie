package com.onea.talkietalkie.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public @Data class Presenter {
    @Id
    public Integer id;
    public Integer name;
}