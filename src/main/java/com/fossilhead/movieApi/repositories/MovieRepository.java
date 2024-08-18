package com.fossilhead.movieApi.repositories;

import com.fossilhead.movieApi.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MovieRepository extends JpaRepository<Movie, Long> {

}
