package org.example.jdbc.mapper;

import org.example.jdbc.model.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements RowMapper<Film> {
    @Override
    public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
        Film film = new Film();
        film.setFilmId(rs.getLong("film_id"));
        film.setDescription(rs.getString("description"));
        film.setRating(rs.getString("rating"));
        film.setTitle(rs.getString("title"));
        film.setYear(rs.getLong("release_year"));
        return film;
    }
}
