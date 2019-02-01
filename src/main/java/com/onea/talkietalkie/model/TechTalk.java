package com.onea.talkietalkie.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="tech_talk")
public class TechTalk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "presenter_id")
    private Presenter presenter;
    @Column(name = "title")
    public String Title;
    @Column(name="talk_date")
    public Timestamp talkDate;

}
