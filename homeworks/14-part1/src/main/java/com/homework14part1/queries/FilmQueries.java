package com.homework14part1.queries;

public interface FilmQueries {
    String GET_FILMS_BY_ACTOR_NAME = "SELECT * FROM film WHERE title IN (SELECT DISTINCT title FROM film INNER JOIN film_actor ON film_actor.film_id IN (SELECT film_id from film_actor INNER JOIN actor ON actor.actor_id = film_actor.actor_id WHERE actor.actor_id IN (SELECT actor_id from actor WHERE actor.first_name LIKE :actorName OR actor.last_name LIKE :actorName)))";
}
