package com.TrainBooking.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TrainBooking.app.dto.TrainBookingResponseDTO;
import com.TrainBooking.app.entity.Booking;


@Repository
public interface TrainBookingRepo extends JpaRepository<Booking,Integer>{

	@Query("Select new com.TrainBooking.app.dto.TrainBookingResponseDTO"
			+ "(a.bookingId,a.bookingticket,a.dateTime,a.passengerName,a.passengerEmail,a.passengerPhone) "
			+ "from Booking a where a.userId=:userId")
	List<TrainBookingResponseDTO> findByUserId(Integer userId);
	
}
