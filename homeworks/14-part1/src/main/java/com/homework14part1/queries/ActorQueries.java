package com.homework14part1.queries;

public interface ActorQueries {
    String GET_ACTORS_BY_ACTOR_NAME = "SELECT * FROM actor WHERE actor.first_name LIKE :actorName OR actor.last_name LIKE :actorName";

    String GET_ACTOR_BY_ACTOR_ID = "SELECT * FROM actor WHERE actor.actor_id = :actorId";

}
