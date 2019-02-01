package com.onea.talkietalkie.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public @Data class Presenter {
    @Id
    public Long id;
    public Integer name;
}