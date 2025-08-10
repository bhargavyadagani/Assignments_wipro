package com.example.movie_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_api.model.Booking;
import com.example.movie_api.repository.BookingRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() 
    {
    	return bookingRepository.findAll(); 
    }
    
    public Optional<Booking> getBookingById(Long id)
    {
    	return bookingRepository.findById(id); 
    }
    
    public Booking saveBooking(Booking booking) 
    {
    	return bookingRepository.save(booking);
    }
    
    public Booking updateBooking(Long id, Booking booking) {
        Booking book=bookingRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Booking not found"));
        book.setBookingDate(booking.getBookingDate());
        book.setSeats(booking.getSeats());
        return bookingRepository.save(book);
    }
    
    public void deleteBooking(Long id) 
    { 
    	bookingRepository.deleteById(id); 
    }
}
