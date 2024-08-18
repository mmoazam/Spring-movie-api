package com.fossilhead.movieApi.service;

import com.fossilhead.movieApi.dto.MovieDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface MovieService {

    MovieDto addMovie(MovieDto movieDto, MultipartFile movieFile) throws IOException;

    MovieDto getMovie(Integer movieId);

    List<MovieDto> getAllMovies();
}
