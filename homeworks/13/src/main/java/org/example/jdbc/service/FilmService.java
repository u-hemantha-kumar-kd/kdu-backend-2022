package org.example.jdbc.service;
import org.example.jdbc.model.Actor;
import org.example.jdbc.model.Film;

import java.util.List;

public interface FilmService {
    List<Actor> getActorbyID(Long id);

    List<Actor> getActorByActorName(String name);

    List<Film> getMoviesByActorName(String name);
}
