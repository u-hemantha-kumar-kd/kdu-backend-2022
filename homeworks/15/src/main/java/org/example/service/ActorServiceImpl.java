package org.example.service;

import org.example.dto.ActorDTO;
import org.example.mapper.ActorMapper;
import org.example.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorMapper actorMapper;


    @Override
    public ActorDTO getActorById(Long id) {
        return actorRepository.findById(id).map(ActorMapper::fromEntity).orElse(null);
    }

    @Override
    public List<ActorDTO> getActorByFirstName(String firstName) {
        return actorRepository.getActorByFirstName(firstName).stream().map(ActorMapper::fromEntity).collect(Collectors.toList());
    }

}