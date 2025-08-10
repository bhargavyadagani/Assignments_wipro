package com.example.booking_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.booking_service.model.Booking;

//@Repository
public interface BookingRepository extends MongoRepository<Booking,String>{

}
