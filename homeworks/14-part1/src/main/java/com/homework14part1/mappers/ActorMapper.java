package com.homework14part1.mappers;

import com.homework14part1.models.Actor;
import com.homework14part1.dao.entities.ActorEntity;

public class ActorMapper {
    public static Actor fromEntity(ActorEntity actorEntity) {
        Actor actor = new Actor();
        actor.setActorId(actorEntity.getActorId());
        actor.setFirstName(actorEntity.getFirstName());
        actor.setLastName(actorEntity.getLastName());
        return actor;
    }
}
