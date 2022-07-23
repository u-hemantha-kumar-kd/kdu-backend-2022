package org.example.service;

import org.example.dto.ActorDTO;

import java.util.List;

public interface ActorService {

    ActorDTO getActorById(Long id);

    List<ActorDTO> getActorByFirstName(String firstName);
}
