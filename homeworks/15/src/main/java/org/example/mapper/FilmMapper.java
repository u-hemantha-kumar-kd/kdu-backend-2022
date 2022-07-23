package org.example.mapper;

import org.example.dto.FilmDTO;
import org.example.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FilmMapper {
    @Autowired
    private ActorMapper actorMapper;

    public FilmDTO fromEntity(Film entity) {
        FilmDTO film = new FilmDTO();
        film.setYear(entity.getYear());
        film.setFilmId(entity.getId());
        film.setRating(entity.getRating());
        film.setTitle(entity.getTitle());
        film.setDescription(entity.getDescription());
        film.setActors(entity.getActors().stream().map(ActorMapper::fromEntity).collect(Collectors.toList()));
        return film;
    }

    public Film toEntity(FilmDTO filmDTO) {
        Film film = new Film();
        film.setTitle(filmDTO.getTitle());
        film.setDescription(filmDTO.getDescription());
        film.setRating(filmDTO.getRating());
        film.setYear(filmDTO.getYear());
        return film;
    }
}
