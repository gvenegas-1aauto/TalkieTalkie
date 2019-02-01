package com.onea.talkietalkie.repository;

import com.onea.talkietalkie.model.TechTalk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechTalkRepository extends JpaRepository<TechTalk,Long> {
}