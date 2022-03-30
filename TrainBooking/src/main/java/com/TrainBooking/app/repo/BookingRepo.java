package com.TrainBooking.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TrainBooking.app.entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
