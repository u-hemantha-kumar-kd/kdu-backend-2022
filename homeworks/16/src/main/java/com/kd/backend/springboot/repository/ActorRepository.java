package com.kd.backend.springboot.repository;

import com.kd.backend.springboot.dto.ActorDTO;
import com.kd.backend.springboot.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> getActorByFirstName(String firstName);
}