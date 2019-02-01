package com.onea.talkietalkie.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="rate")
public  class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tech_talk_id")
    private TechTalk techTalk;
    @Column(name="rating")
    public Integer rating;
    @Column(name="reason")
    public String reason;
}