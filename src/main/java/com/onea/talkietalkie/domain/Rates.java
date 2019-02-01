package com.onea.talkietalkie.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public @Data class Rates {
    @Id
    public Integer id;
    public Integer userId;
    public Integer techTalkId;
    public Integer rating;
    public String reason;
}