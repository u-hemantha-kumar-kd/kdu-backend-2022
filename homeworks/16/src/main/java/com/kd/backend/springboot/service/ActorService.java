package com.kd.backend.springboot.service;

import com.kd.backend.springboot.dto.ActorDTO;

import java.util.List;

public interface ActorService {

    ActorDTO getActorById(Long id);

    List<ActorDTO> getActorByFirstName(String firstName);
}
