package org.example.controller;

import org.example.dto.ActorDTO;
import org.example.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/actor/")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @GetMapping("/{actorId}")
    public ResponseEntity<ActorDTO> getById(@PathVariable Long actorId) {
        logger.info("Received a request to fetch actor with id: {}", actorId);
        return Optional.ofNullable(actorService.getActorById(actorId))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(sendNotFound());

    }

    @GetMapping("/name/{firstName}")
    public List<ActorDTO> getByFirstName(@PathVariable String firstName){
        logger.info("Received a request to fetch actor with name: {}", firstName);
        return actorService.getActorByFirstName(firstName);
    }

    private ResponseEntity<ActorDTO> sendNotFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
