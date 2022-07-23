package com.homework14part1.dao;

import com.homework14part1.mappers.FilmMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.homework14part1.dao.entities.ActorEntity;
import com.homework14part1.models.Film;

import java.util.List;
import java.util.stream.Collectors;

@Repository("filmDao")
@Transactional("hibernateTransactionManager")
public class FilmDaoImplementation implements FilmDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Film> getFilmsByActorName(String actorName) {
        String hql = "FROM ActorEntity a WHERE a.firstName LIKE :actorName OR a.lastName LIKE :actorName";
        Session session = sessionFactory.getCurrentSession();
        Query<ActorEntity> query = session.createQuery(hql);
        query.setParameter("actorName", "%" + actorName + "%");
        List<ActorEntity> actors = query.list();
        return actors.stream()
                .flatMap(actorEntity -> actorEntity.getFilmEntities().stream())
                .map(FilmMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
