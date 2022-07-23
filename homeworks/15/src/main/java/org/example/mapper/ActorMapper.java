package org.example.mapper;

import org.example.dto.ActorDTO;
import org.example.entity.Actor;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {

    public static ActorDTO fromEntity(Actor actor) {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setId(actor.getId());
        actorDTO.setFirstName(actor.getFirstName());
        actorDTO.setLastName(actor.getLastName());
        actorDTO.setLastUpdate(actor.getLastUpdate());
        return actorDTO;
    }
}
