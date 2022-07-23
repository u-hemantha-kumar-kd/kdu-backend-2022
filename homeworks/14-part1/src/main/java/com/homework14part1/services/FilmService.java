package com.homework14part1.services;

import com.homework14part1.models.Actor;

import java.util.List;

public interface FilmService {
    List<String> getFilmNamesByActorName(String actorName);

    List<Actor> getActorsByActorName(String actorName);

    List<Actor> getActorByActorId(int actorId);
}
