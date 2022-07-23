package com.homework14part1.dao.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class FilmActorId implements Serializable {
    @Column(name = "film_id")
    private int filmId;

    @Column(name = "actor_id")
    private Long actorId;
}
