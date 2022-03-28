package com.TrainBooking.app.service;

import org.springframework.http.ResponseEntity;

import com.TrainBooking.app.dto.TrainDetailsResponseDto;

public interface TrainBookingTrainService {

	ResponseEntity<TrainDetailsResponseDto> getTrainById(Integer trainId);

}
