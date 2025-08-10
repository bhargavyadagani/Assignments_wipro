package com.example.hotel_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel_booking.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

}
