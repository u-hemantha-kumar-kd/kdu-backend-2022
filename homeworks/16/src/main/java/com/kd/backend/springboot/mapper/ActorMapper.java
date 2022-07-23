package com.kd.backend.springboot.mapper;

import com.kd.backend.springboot.dto.ActorDTO;
import com.kd.backend.springboot.entity.Actor;
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
