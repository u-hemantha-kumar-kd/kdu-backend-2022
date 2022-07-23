package com.homework14part1.dao;

import com.homework14part1.models.Actor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorDao {

    List<Actor> getActorsByActorName(String actorName);

    Actor getActorByActorId(int actorId);
}
