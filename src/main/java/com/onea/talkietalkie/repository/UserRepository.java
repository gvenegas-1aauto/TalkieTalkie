package com.onea.talkietalkie.repository;


import com.onea.talkietalkie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
