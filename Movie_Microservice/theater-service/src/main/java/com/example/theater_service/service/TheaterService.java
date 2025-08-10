package com.example.theater_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_service.model.Theater;
import com.example.theater_service.repository.TheaterRepository;

@Service
public class TheaterService {
	
	@Autowired
	private TheaterRepository theaterrepository;
	
	
	
	public List<Theater> getAllTheater()
	{
		return theaterrepository.findAll();
	}
	
	public Optional<Theater> getTheaterById(Long id)
	{
		return theaterrepository.findById(id);
	}
	public Theater addTheater(Theater theater)
	{
		return theaterrepository.save(theater);
	}
	public Theater updateTheater(Long id, Theater theaterDetails) {
        Theater theater = theaterrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theater not found"));

        theater.setName(theaterDetails.getName());
        theater.setLocation(theaterDetails.getLocation());

        return theaterrepository.save(theater);
    }
	public void deleteTheater(long id)
	{
		 theaterrepository.deleteById(id);
	}
}

