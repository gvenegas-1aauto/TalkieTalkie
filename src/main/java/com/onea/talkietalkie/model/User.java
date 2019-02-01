package com.onea.talkietalkie.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public  class User {
    @Id
    public Long id;
    public String name;
}