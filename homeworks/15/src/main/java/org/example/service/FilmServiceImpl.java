package org.example.service;

import org.example.dto.FilmDTO;
import org.example.mapper.FilmMapper;
import org.example.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmMapper filmMapper;

    @Override
    public List<FilmDTO> getFilmsOfYear(Long year, Integer limit) {
        return filmRepository.findByYear(year)
                .stream()
                .limit(limit)
                .map(filmMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public FilmDTO getFilmById(Long id) {
        return filmRepository.findById(id).map(filmMapper::fromEntity).orElse(null);
    }

    @Override
    public Set<FilmDTO> getFilmByTitle(String title) {
        return filmRepository.findByTitleLike(title)
                .stream()
                .map(filmMapper::fromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<FilmDTO> getFilmByYearAndRating(Long year, String rating) {
        return filmRepository.findByYearAndRatingLike(year, rating)
                .stream()
                .map(filmMapper::fromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public FilmDTO createFilm(FilmDTO filmDTO) {
        filmRepository.findAll();
        return filmMapper.fromEntity(filmRepository.save(filmMapper.toEntity(filmDTO)));
    }
}
