package com.TrainBooking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.TrainBooking.app.dto.TrainBookingResponseDTO;
import com.TrainBooking.app.service.TrainBookingService;

@RestController
public class TrainBookingController {

	@Autowired
	TrainBookingService trainBookingService;
		
	@GetMapping("/GetBooking/{userId}")
	public List<TrainBookingResponseDTO> GetBookingByUser(@PathVariable Integer userId){		
		
		List<TrainBookingResponseDTO> trainBookingResponseDTO = trainBookingService.getBookingByUserId(userId);
		return trainBookingResponseDTO;
	}
}
