package org.example.jdbc.service;

import org.example.jdbc.dao.FilmDao;
import org.example.jdbc.model.Actor;
import org.example.jdbc.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    @Qualifier("jdbcTemplateDao")
    private FilmDao filmDao;

    @Override
    public List<Film> getMoviesByActorName(String name) {
        return filmDao.getMovieByActor(name);
    }

    @Override
    public List<Actor> getActorByActorName(String name) {
        return  filmDao.getActorByActor(name);
    }

    @Override
    public List<Actor> getActorbyID(Long id) {
        return filmDao.getActorById(id);
    }

 


}
