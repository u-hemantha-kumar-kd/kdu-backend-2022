package com.homework14part1.mappers;

import com.homework14part1.dao.entities.FilmEntity;
import com.homework14part1.models.Film;

public class FilmMapper {
    public static Film fromEntity(FilmEntity filmEntity) {
        Film film = new Film();
        film.setFilmId(filmEntity.getFilmId());
        film.setTitle(filmEntity.getTitle());
        film.setDescription(filmEntity.getDescription());
        return film;
    }
}
