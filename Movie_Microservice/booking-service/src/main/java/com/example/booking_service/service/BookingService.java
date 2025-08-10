package com.example.booking_service.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.booking_service.model.Booking;
import com.example.booking_service.repository.BookingRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() 
    {
    	return bookingRepository.findAll(); 
    }
    
    public Optional<Booking> getBookingById(String id)
    {
    	return bookingRepository.findById(id); 
    }
    
    public Booking saveBooking(int seat) 
    {
    	Booking booking = new Booking();
        booking.setSeats(seat);
  	    booking.setBookingDate(LocalDate.now()); 
    	return bookingRepository.save(booking);
    }
    
    public Booking updateBooking(String id, Booking booking) {
        Booking book=bookingRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Booking not found"));
        book.setBookingDate(booking.getBookingDate());
        book.setSeats(booking.getSeats());
        return bookingRepository.save(book);
    }
    
    public void deleteBooking(String id) 
    { 
    	bookingRepository.deleteById(id); 
    }
}

