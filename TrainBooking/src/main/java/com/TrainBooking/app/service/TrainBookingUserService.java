package com.TrainBooking.app.service;

import org.springframework.http.ResponseEntity;

import com.TrainBooking.app.dto.UserDTO;
import com.TrainBooking.app.dto.UserRequestDTO;
import com.TrainBooking.app.dto.UserResponseDTO;

public interface TrainBookingUserService {

	ResponseEntity<UserResponseDTO> AthenticateUser(UserRequestDTO userRequestDTO);

	ResponseEntity<UserResponseDTO> UserRegistration(UserDTO user);

	ResponseEntity<UserDTO> getUserById(Integer userId);
	
	ResponseEntity<UserResponseDTO> AthenticateUserResi(UserRequestDTO userRequestDTO);

}
