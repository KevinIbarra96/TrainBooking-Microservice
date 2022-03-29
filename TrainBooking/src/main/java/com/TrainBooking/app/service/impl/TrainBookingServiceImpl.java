package com.TrainBooking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrainBooking.app.client.TravelClient;
import com.TrainBooking.app.client.UserClient;
import com.TrainBooking.app.dto.TrainBookingResponseDTO;
import com.TrainBooking.app.dto.TravelDTO;
import com.TrainBooking.app.dto.UserDTO;
import com.TrainBooking.app.repo.TrainBookingRepo;
import com.TrainBooking.app.service.TrainBookingService;

@Service
public class TrainBookingServiceImpl implements TrainBookingService{

	@Autowired(required=false)
	UserClient userClient;
	
	@Autowired(required=false)
	TravelClient travelClient;
	
	@Autowired
	TrainBookingRepo trainBookingRepo;

	@Override
	public List<TrainBookingResponseDTO> getBookingByUserId(Integer userId) {
		
		List<TrainBookingResponseDTO> trainBookingResponseDTO = trainBookingRepo.findByUserId(userId);	
		
		trainBookingResponseDTO.forEach(res ->{
			res.setUser(userClient.GetUserById(userId).getBody());
			res.setTravel(travelClient.getTravelById(userId).getBody());
		});
		
		return trainBookingResponseDTO;
	}
	
}
