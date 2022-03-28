package com.TrainBooking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.TrainBooking.app.dto.TrainDetailsResponseDto;
import com.TrainBooking.app.service.TrainBookingTrainService;

@RestController
public class TrainBookingTrainController {

	@Autowired
	TrainBookingTrainService trainBookingTrainService;
	
	@GetMapping("/TrainBooking/trains/{trainId}")
	public ResponseEntity<TrainDetailsResponseDto> getTrainById(@PathVariable Integer trainId){
		return trainBookingTrainService.getTrainById(trainId);
	}
	
}
