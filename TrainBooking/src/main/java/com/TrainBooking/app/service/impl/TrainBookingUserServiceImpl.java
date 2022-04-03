package com.TrainBooking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TrainBooking.app.client.UserClient;
import com.TrainBooking.app.dto.TrainBookingResponseDTO;
import com.TrainBooking.app.dto.UserDTO;
import com.TrainBooking.app.dto.UserRequestDTO;
import com.TrainBooking.app.dto.UserResponseDTO;
import com.TrainBooking.app.exception.ServerDownException;
import com.TrainBooking.app.service.TrainBookingUserService;

@Service
public class TrainBookingUserServiceImpl implements TrainBookingUserService{
	
	@Autowired(required = false)
	UserClient userClient;
	
	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;
	
	@Override
	public ResponseEntity<UserResponseDTO> AthenticateUserResi(UserRequestDTO userRequestDTO){
		
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		return circuitBreaker.run(() -> userClient.Login(userRequestDTO),
				throwable -> {
					throw new ServerDownException("UserService Down"); 
				});
	}	
	
	@Override
	public ResponseEntity<UserResponseDTO> AthenticateUser(UserRequestDTO userRequestDTO) {
		
		return userClient.Login(userRequestDTO);
	}

	@Override
	public ResponseEntity<UserResponseDTO> UserRegistration(UserDTO user) {		
		return userClient.UserRegistration(user);
	}

	@Override
	public ResponseEntity<UserDTO> getUserById(Integer userId) {		
		return userClient.GetUserById(userId);
	}
}
