package com.movieflix.movieApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.movieApi.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
