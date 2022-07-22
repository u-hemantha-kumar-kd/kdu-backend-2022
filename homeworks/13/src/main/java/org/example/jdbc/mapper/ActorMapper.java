package org.example.jdbc.mapper;

import org.example.jdbc.model.Actor;
import org.example.jdbc.model.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper implements RowMapper<Actor> {
    @Override
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Actor actor = new Actor();
        actor.setActorId(rs.getLong("actor_id"));
        actor.setFirst_name(rs.getString("first_name"));
        actor.setFirst_name(rs.getString("last_name"));
        return actor;
    }

//    public static Film fromEntity(FilmEntity entity) {
//        Film film = new Film();
//        film.setYear(entity.getYear());
//        film.setFilmId(entity.getId());
//        film.setRating(entity.getRating());
//        film.setTitle(entity.getTitle());
//        film.setDescription(entity.getDescription());
//        return film;
//    }
}
