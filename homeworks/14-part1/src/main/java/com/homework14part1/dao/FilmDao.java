package com.homework14part1.dao;

import org.springframework.stereotype.Repository;
import com.homework14part1.models.Film;

import java.util.List;

@Repository
public interface FilmDao {
    List<Film> getFilmsByActorName(String actorName);
}
