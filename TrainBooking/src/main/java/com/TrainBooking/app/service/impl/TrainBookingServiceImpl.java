package com.TrainBooking.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.TrainBooking.app.client.TravelClient;
import com.TrainBooking.app.client.UserClient;
import com.TrainBooking.app.dto.TrainBookingDTO;
import com.TrainBooking.app.dto.TrainBookingResponseDTO;
import com.TrainBooking.app.dto.UserDTO;
import com.TrainBooking.app.exception.ServerDownException;
import com.TrainBooking.app.exception.UserNotFoundException;
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
	
	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;

	public TrainBookingResponseDTO getBookingByUserIdResi(Integer userId){
		
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		return circuitBreaker.run(() -> getBookingByUserId(userId),
				throwable -> {
					throw new ServerDownException("UserService or TravelService Down"); 
				});
		
	}
	
	@Override
	public TrainBookingResponseDTO getBookingByUserId(Integer userId) {
		
		UserDTO userDTO = userClient.GetUserById(userId).getBody();
		TrainBookingResponseDTO trainBookingResponseDTO = new TrainBookingResponseDTO();
		
		
		if(userDTO.getUsername()==null) {
			System.out.print("UserNotFoundException");
			throw new UserNotFoundException("User not found");
		}
		
		List<TrainBookingDTO> trainBookingDTO = trainBookingRepo.findByUserId(userId);	
		 
		trainBookingDTO.forEach(res ->{			
			res.setTravel(travelClient.getTravelById(res.getTavelId()).getBody());
		});
		trainBookingResponseDTO.setUser(userDTO);
		trainBookingResponseDTO.setTrainBooking(trainBookingDTO);
		
		return trainBookingResponseDTO;
	}
	
}
