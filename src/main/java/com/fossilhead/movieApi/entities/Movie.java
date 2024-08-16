package com.fossilhead.movieApi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(nullable = false)
    @NotBlank(message = "Title cannot be blank.")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Director cannot be blank.")
    private String director;

    @Column(nullable = false)
    @NotBlank(message = "Studio cannot be blank.")
    private String studio;

    @ElementCollection
    @CollectionTable(name = "movie_cast")
    private Set<String> movieCast;

    @Column(nullable = false)
    @NotBlank(message = "Release year cannot be blank.")
    private Integer releaseYear;

    @Column(nullable = false)
    @NotBlank(message = "Poster cannot be blank.")
    private String poster;


}
