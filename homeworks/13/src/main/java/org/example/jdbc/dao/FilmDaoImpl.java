package org.example.jdbc.dao;

import org.example.jdbc.mapper.ActorMapper;
import org.example.jdbc.mapper.FilmMapper;
import org.example.jdbc.model.Actor;
import org.example.jdbc.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("jdbcTemplateDao")
public class FilmDaoImpl implements FilmDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FilmDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Film> getFilmsByYear(Long year) {
        return jdbcTemplate.query(FilmQueries.GET_FILM_BY_YEAR,
                new Object[]{year},
                new int[]{Types.INTEGER},
                new FilmMapper());
    }

    @Override
    public Film getFilmById(Long id) {
        return jdbcTemplate.queryForObject(FilmQueries.GET_FILM_BY_ID,
                new Object[]{id},
                new int[]{Types.INTEGER},
                new FilmMapper());
    }

    @Override
    public Set<Film> getFilmByTitle(String title) {
        return new HashSet<>(jdbcTemplate.query(FilmQueries.GET_FILM_BY_title,
                new Object[]{title},
                new int[]{Types.VARCHAR},
                new FilmMapper()));
    }

    @Override
    public List<Actor> getActorById(Long id) {
        return jdbcTemplate.query(FilmQueries.GET_ACTOR_BY_id,
                new Object[]{id},
                new int[]{Types.INTEGER},
                new ActorMapper());
    }

    @Override
    public List<Actor> getActorByActor(String name) {
        return jdbcTemplate.query(FilmQueries.GET_ACTOR_BY_Actor,
                new Object[]{name},
                new int[]{Types.VARCHAR},
                new ActorMapper());
    }

    @Override
    public List<Film> getMovieByActor(String name) {
        return jdbcTemplate.query(FilmQueries.GET_MOVIE_BY_Actor,
                new Object[]{name},
                new int[]{Types.VARCHAR},
                new FilmMapper());
    }
}
