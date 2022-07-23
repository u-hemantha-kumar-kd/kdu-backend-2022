package com.homework14part1.dao.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Cache;

@Entity
@Table(name = "actor")
@Data
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ActorEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private int actorId;

    @NotEmpty(message = "First name can not be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last Name can not be empty")
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"))
    private List<FilmEntity> filmEntities;
}
