package com.TrainBooking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TrainBooking.app.client.TrainClient;
import com.TrainBooking.app.dto.TrainDetailsResponseDto;
import com.TrainBooking.app.service.TrainBookingTrainService;

@Service
public class TrainBookingTrainServiceImp implements TrainBookingTrainService{
	
	@Autowired
	TrainClient trainClient;
	
	@Override
	public ResponseEntity<TrainDetailsResponseDto> getTrainById(Integer trainId) {		
		return trainClient.getTrainById(trainId);
	}

}
