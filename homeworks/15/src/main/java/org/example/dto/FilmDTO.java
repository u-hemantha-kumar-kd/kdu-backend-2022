package org.example.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FilmDTO implements Serializable {
    private Long filmId;
    private String title;
    private String description;
    private Long year;
    private String rating;
    private List<ActorDTO> actors;
}
