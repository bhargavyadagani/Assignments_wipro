package com.example.movie_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie_api.model.Movies;
@org.springframework.stereotype.Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {

	Optional<Movies> findByTitle(String title);
}
