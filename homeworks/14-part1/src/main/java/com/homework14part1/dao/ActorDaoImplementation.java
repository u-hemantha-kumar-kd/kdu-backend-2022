package com.homework14part1.dao;

import com.homework14part1.mappers.ActorMapper;
import com.homework14part1.models.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.homework14part1.dao.entities.ActorEntity;

import java.util.List;
import java.util.stream.Collectors;

@Repository("actorDao")
@Transactional("hibernateTransactionManager")
public class ActorDaoImplementation implements ActorDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Actor> getActorsByActorName(String actorName) {
        String hql = "FROM ActorEntity a WHERE a.firstName LIKE :actorName OR a.lastName LIKE :actorName";
        Session session = sessionFactory.getCurrentSession();
        Query<ActorEntity> query = session.createQuery(hql);
        query.setParameter("actorName", "%" + actorName + "%");
        return query.list().stream().map(ActorMapper::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Actor getActorByActorId(int actorId) {
        String hql = "FROM ActorEntity a WHERE a.actorId = :actorId";
        Session session = sessionFactory.getCurrentSession();
        Query<ActorEntity> query = session.createQuery(hql);
        query.setParameter("actorId", actorId);
        return query.list().stream().map(ActorMapper::fromEntity).collect(Collectors.toList()).get(0);
    }
}
