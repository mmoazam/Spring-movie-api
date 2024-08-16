package com.fossilhead.movieApi.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class MovieDto {

    private Long movieId;

    @NotBlank(message = "Title cannot be blank.")
    private String title;

    @NotBlank(message = "Director cannot be blank.")
    private String director;

    @NotBlank(message = "Studio cannot be blank.")
    private String studio;

    private Set<String> movieCast;

    private Integer releaseYear;

    @NotBlank(message = "Poster cannot be blank.")
    private String poster;

    @NotBlank(message = "PosterUrl cannot be blank.")
    private String posterUrl;
}
