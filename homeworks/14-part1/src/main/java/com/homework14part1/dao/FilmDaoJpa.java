package com.homework14part1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.homework14part1.dao.entities.FilmEntity;

import java.util.List;

@Repository
public interface FilmDaoJpa extends JpaRepository<FilmEntity, Integer> {
    @Query(value = "SELECT * FROM film WHERE title IN (SELECT DISTINCT title FROM film INNER JOIN film_actor ON film_actor.film_id IN (SELECT film_id from film_actor INNER JOIN actor ON actor.actor_id = film_actor.actor_id WHERE actor.actor_id IN (SELECT actor_id from actor WHERE actor.first_name LIKE :actorName OR actor.last_name LIKE :actorName)))", nativeQuery = true)
    List<FilmEntity> getFilmsByActorName(@Param("actorName") String actorName);
}
