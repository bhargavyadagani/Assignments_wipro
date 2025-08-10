package com.example.movie_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_api.model.Movies;
import com.example.movie_api.service.MovieService;

@RestController
@RequestMapping("/movies")
public class AppController {
	@Autowired
	private MovieService movieservice;
	@GetMapping
	public List<Movies> getAllMovies()
	{
		return movieservice.getAllMovies();
	}
	@PostMapping
	public Movies createMovie(@RequestBody Movies movies)
	{
		return movieservice.addMovie(movies);
	}
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id)
	{
		movieservice.deleteMovie(id);
	}
}
