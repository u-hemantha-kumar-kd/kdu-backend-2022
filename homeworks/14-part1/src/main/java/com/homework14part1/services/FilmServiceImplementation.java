package com.homework14part1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.homework14part1.dao.ActorDaoJpa;
import com.homework14part1.dao.FilmDaoJpa;
import com.homework14part1.mappers.ActorMapper;
import com.homework14part1.models.Actor;

//import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("filmService")
@Transactional("transactionManager")
public class FilmServiceImplementation implements FilmService {
    @Autowired
    private FilmDaoJpa filmDao;

    @Autowired
    private ActorDaoJpa actorDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
    public List<String> getFilmNamesByActorName(String actorName) {
        return filmDao.getFilmsByActorName(actorName).stream().map(film -> film.getTitle()).collect(Collectors.toList());
    }

    @Override
    public List<Actor> getActorsByActorName(String actorName) {
        return actorDao.getActorsByActorName(actorName).stream()
                .map(ActorMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Actor> getActorByActorId(int actorId) {

        return Stream.of(actorDao.getActorByActorId(actorId))
                .map(ActorMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
