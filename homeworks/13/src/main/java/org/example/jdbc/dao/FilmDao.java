package org.example.jdbc.dao;

import org.example.jdbc.model.Actor;
import org.example.jdbc.model.Film;

import java.util.List;
import java.util.Set;

public interface FilmDao {
    List<Film> getFilmsByYear(Long year);

    Film getFilmById(Long id);

    Set<Film> getFilmByTitle(String title);

    List<Actor> getActorById(Long id);

    List<Actor> getActorByActor(String name);

    List<Film> getMovieByActor(String name);
}
