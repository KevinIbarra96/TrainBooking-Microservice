package com.TrainBooking.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.TrainBooking.app.dto.BookingRequestDto;
import com.TrainBooking.app.dto.ResponseDto;
import com.TrainBooking.app.dto.TrainDetailsResponseDto;

public interface TrainBookingTrainService {

	ResponseEntity<TrainDetailsResponseDto> getTrainById(Integer trainId);
	
	ResponseDto bookTravel(List<BookingRequestDto> bookingRequestDtoList);
}
