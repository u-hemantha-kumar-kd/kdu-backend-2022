package com.kd.backend.springboot.controller;

import com.kd.backend.springboot.dto.ActorDTO;
import com.kd.backend.springboot.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/actor/")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(ActorController.class);

    @GetMapping("/{actorId}")
    public ResponseEntity<ActorDTO> getById(@PathVariable Long actorId) {
        logger.info("Received a request to fetch actor with id: {}", actorId);
        return Optional.ofNullable(actorService.getActorById(actorId))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(sendNotFound());

    }

    @GetMapping("/name/{firstName}")
    public ResponseEntity<List<ActorDTO>> getByFirstName(@PathVariable String firstName){
        logger.info("Received a request to fetch actor with name: {}", firstName);
        return Optional.ofNullable(actorService.getActorByFirstName(firstName))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(sendNotFounds());
    }

    @GetMapping(value = "/")
    public List<ActorDTO> getAllFilms(@PathParam("year") Long year, @RequestHeader("x-limit") Integer limit) {
        throw new NullPointerException();
    }

    private ResponseEntity<List<ActorDTO>> sendNotFounds(){return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);}
    private ResponseEntity<ActorDTO> sendNotFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
