package com.fossilhead.movieApi.repositories;

import com.fossilhead.movieApi.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
