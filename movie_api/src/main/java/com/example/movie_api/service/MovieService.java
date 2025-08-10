package com.example.movie_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_api.model.Movies;
import com.example.movie_api.repository.MoviesRepository;

@Service
public class MovieService {
	@Autowired
	private MoviesRepository moviesrepository;
	
	public List<Movies> getAllMovies()
	{
		return moviesrepository.findAll();
	}
	
	public Movies addMovie(Movies movie)
	{
		return moviesrepository.save(movie);
	}
	
	public void deleteMovie(Long id)
	{
		 moviesrepository.deleteById(id);
	}
	
	public Optional<Movies> getByName(String title)
	{
		return moviesrepository.findByTitle(title);
	}
}
