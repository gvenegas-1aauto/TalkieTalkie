package com.onea.talkietalkie.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="presenter")
@Data
public  class Presenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="name")
    public String name;
    @OneToMany(
            cascade = CascadeType.REFRESH,
            orphanRemoval = true,
            mappedBy = "presenter"
    )
    private Collection<TechTalk> techTalks;
}