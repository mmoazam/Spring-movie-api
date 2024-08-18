package com.fossilhead.movieApi.service;

import com.fossilhead.movieApi.dto.MovieDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class MovieServiceImpl implements MovieService{
    @Override
    public MovieDto addMovie(MovieDto movie, MultipartFile movieFile) {
        return null;
    }

    @Override
    public MovieDto getMovie(Integer movieId) {
        return null;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return List.of();
    }
}
