package com.onea.talkietalkie.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="name")
    public String name;
}