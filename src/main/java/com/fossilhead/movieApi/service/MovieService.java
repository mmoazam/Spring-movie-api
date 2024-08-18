package com.fossilhead.movieApi.service;

import com.fossilhead.movieApi.dto.MovieDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieService {

    MovieDto addMovie(MovieDto movie, MultipartFile movieFile);

    MovieDto getMovie(Integer movieId);

    List<MovieDto> getAllMovies();
}
