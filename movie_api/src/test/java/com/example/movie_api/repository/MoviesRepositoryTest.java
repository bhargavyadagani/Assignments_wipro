package com.example.movie_api.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.movie_api.model.Movies;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MoviesRepositoryTest {

	@Autowired
	private MoviesRepository movierepository;
	@Test
	public void testSaveMovie()
	{
		Movies movie=new Movies();
		
		movie.setTitle("War2");
		movie.setGenre("Action-drama");
		
		Movies mv=movierepository.save(movie);
		
		assertEquals(mv.getTitle(),"War2");
	}
	
	@Test
	public void testFindById()
	{
		Movies movie=new Movies();
		
		movie.setTitle("War2");
		movie.setGenre("Action-drama");
		movierepository.save(movie);
		
		Movies mv=movierepository.findById(1L).get();
		
		assertEquals(mv.getId(),1L);
	}
	
	@Test
	public void testFinfByName()
	{
		Movies movie=new Movies();
		
		movie.setTitle("Kingdom");
		movie.setGenre("Action-drama");
		movierepository.save(movie);
		Optional<Movies> fetched = movierepository.findByTitle("Kingdom");
        assertTrue(fetched.isPresent());
        assertEquals("Kingdom", fetched.get().getTitle());
	}
	
	 @Test
	    void testUpdateMovie() {
	        // Step 1: Save a new movie
	        Movies movie = new Movies();
	        movie.setTitle("Kingdom");
	        movie.setGenre("Action-drama");
	        Movies savedMovie = movierepository.save(movie);

	        // Step 2: Update the movie's title
	        savedMovie.setTitle("Devara");
	        Movies updatedMovie = movierepository.save(savedMovie);  // Save the updated entity

	        // Step 3: Fetch from DB and verify update
	        Optional<Movies> fetched = movierepository.findById(updatedMovie.getId());

	        assertTrue(fetched.isPresent(), "Updated movie should exist");
	        assertEquals("Devara", fetched.get().getTitle(), "Title should be updated");
	        assertEquals("Action-drama", fetched.get().getGenre(), "Genre should remain unchanged");
	    }

}
