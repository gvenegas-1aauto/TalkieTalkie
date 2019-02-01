package com.onea.talkietalkie.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="presenter")
@Data
public  class Presenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Integer name;
    @OneToMany(
            cascade = CascadeType.REFRESH,
            orphanRemoval = true,
            mappedBy = "presenter"
    )
    private Collection<TechTalk> techTalks;
}