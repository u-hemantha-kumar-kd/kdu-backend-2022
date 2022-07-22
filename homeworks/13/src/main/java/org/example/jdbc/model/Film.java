package org.example.jdbc.model;

import lombok.Data;

@Data
public class Film {
    private Long filmId;
    private String title;
    private String description;
    private Long year;
    private String rating;
}
