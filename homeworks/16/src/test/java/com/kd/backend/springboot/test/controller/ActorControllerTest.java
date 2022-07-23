package com.kd.backend.springboot.test.controller;

import com.kd.backend.springboot.entity.Actor;
import com.kd.backend.springboot.repository.ActorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ActorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ActorRepository actorRepository;


    @Test
    public void getActorByIdTest() throws Exception {
        Actor actor = new Actor();
        actor.setFirstName("Rajesh");
        actor.setLastName("Pattem");
        actor.setLastUpdate(LocalDateTime.now());

        actor = actorRepository.save(actor);
        System.out.println("Inserted new actor with id: " + actor.getId());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/1")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void getactorByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/100")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGlobalExceptionHandler() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/?year=2006")
                        .header("x-limit", 10)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}