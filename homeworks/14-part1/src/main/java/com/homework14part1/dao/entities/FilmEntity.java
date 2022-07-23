package com.homework14part1.dao.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "FilmEntity")
@Table(name = "film")
@NaturalIdCache
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class FilmEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "film_id")
    private int filmId;

    @NotEmpty(message = "title can not be empty")
    private String title;

    private String description;

    @ManyToMany(mappedBy = "filmEntities")
    private List<ActorEntity> actorEntities;
}
