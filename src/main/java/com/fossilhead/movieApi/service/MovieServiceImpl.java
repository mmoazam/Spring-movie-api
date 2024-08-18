package com.fossilhead.movieApi.service;

import com.fossilhead.movieApi.dto.MovieDto;
import com.fossilhead.movieApi.entities.Movie;
import com.fossilhead.movieApi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final FileService fileService;

    public MovieServiceImpl(MovieRepository movieRepository, FileService fileService) {
        this.movieRepository = movieRepository;
        this.fileService = fileService;
    }

    @Value("${project.poster}")
    private String uploadPath;

    @Value("${base.url}")
    private String baseUrl;

    @Override
    public MovieDto addMovie(MovieDto movieDto, MultipartFile movieFile) throws IOException {

        // upload file
        String uploadedFilename = fileService.uploadFile(uploadPath, movieFile);

        // set the file name of the uploaded file
        movieDto.setPoster(uploadedFilename);

        // map dto to movie object
        Movie movie = new Movie(
                movieDto.getMovieId(),
                movieDto.getTitle(),
                movieDto.getDirector(),
                movieDto.getStudio(),
                movieDto.getMovieCast(),
                movieDto.getReleaseYear(),
                movieDto.getPoster()
        );

        // save the movie object and return the saved movie object
        Movie savedMovie = movieRepository.save(movie);

        // generate the url for the movie poster
        String posterUrl = baseUrl + "/file/" + uploadedFilename;

        //match movie object to dto object.
        MovieDto response = new MovieDto(
                savedMovie.getMovieId(),
                savedMovie.getTitle(),
                savedMovie.getDirector(),
                savedMovie.getStudio(),
                savedMovie.getMovieCast(),
                savedMovie.getReleaseYear(),
                savedMovie.getPoster(),
                posterUrl
        );

        return response;
    }

    @Override
    public MovieDto getMovie(Long movieId) {
        Movie savedMovie = movieRepository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        String posterUrl = baseUrl + "/file/" + savedMovie.getPoster();
        MovieDto movieDto = new MovieDto(
                savedMovie.getMovieId(),
                savedMovie.getTitle(),
                savedMovie.getDirector(),
                savedMovie.getStudio(),
                savedMovie.getMovieCast(),
                savedMovie.getReleaseYear(),
                savedMovie.getPoster(),
                posterUrl
        );
        return movieDto;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return List.of();
    }
}
