package com.example.movie_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_service.dto.TheaterDto;
import com.example.movie_service.feign.MovieClient;
import com.example.movie_service.model.Movie;
import com.example.movie_service.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
	private MovieClient movieClient;
    
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id)
                         .orElseThrow(() -> new RuntimeException("Movie not found"));

        movie.setTitle(movieDetails.getTitle());
        movie.setGenre(movieDetails.getGenre());
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
    
    public Movie createMovieWithTheater(Long theaterId,Movie movie)
    {
    	TheaterDto theater=movieClient.getTheaterById(theaterId);
    	Movie m=new Movie();
    	m.setTheaterId(theater.getId());
    	m.setGenre(movie.getGenre());
    	m.setTitle(movie.getTitle());
    	return movieRepository.save(m);
    }
}