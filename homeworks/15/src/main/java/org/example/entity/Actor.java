package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Actor {
    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    @ToString.Exclude
    private List<Film> films;
}
