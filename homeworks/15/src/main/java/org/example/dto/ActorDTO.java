package org.example.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ActorDTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
}
