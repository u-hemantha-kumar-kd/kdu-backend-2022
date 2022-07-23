package com.homework14part1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.homework14part1.dao.entities.ActorEntity;

import java.util.List;

@Repository
public interface ActorDaoJpa extends JpaRepository<ActorEntity, Integer> {
    @Query(value = "SELECT * FROM actor WHERE actor.first_name LIKE :actorName OR actor.last_name LIKE :actorName", nativeQuery = true)
    List<ActorEntity> getActorsByActorName(@Param("actorName") String actorName);

    @Query(value = "SELECT * FROM actor WHERE actor.actor_id = :actorId", nativeQuery = true)
    ActorEntity getActorByActorId(@Param("actorId") int actorId);
}
