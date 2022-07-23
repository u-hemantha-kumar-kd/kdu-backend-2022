package org.example.controller;

import org.example.dto.FilmDTO;
import org.example.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @GetMapping("/{filmId}")
    public ResponseEntity<FilmDTO> getById(@PathVariable Long filmId) {
        logger.info("Received a request to fetch film with id: {}", filmId);
        return Optional.ofNullable(filmService.getFilmById(filmId))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(sendNotFound());

    }

    private ResponseEntity<FilmDTO> sendNotFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/")
    public List<FilmDTO> getAllFilms(@PathParam("year") Long year, @RequestHeader("x-limit") Integer limit) {
        throw new NullPointerException();
//        return filmService.getFilmsOfYear(year, limit);
    }

    @PostMapping(value = "/")
    public FilmDTO createFilm(@RequestBody FilmDTO filmDTO) {
        return filmService.createFilm(filmDTO);
    }
}
