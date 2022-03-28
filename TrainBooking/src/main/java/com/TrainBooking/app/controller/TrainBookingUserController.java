package com.TrainBooking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TrainBooking.app.dto.UserResponseDTO;
import com.TrainBooking.app.service.TrainBookingUserService;
import com.TrainBooking.app.dto.UserDTO;
import com.TrainBooking.app.dto.UserRequestDTO;

@RestController
public class TrainBookingUserController {
	
	@Autowired
	TrainBookingUserService trainBookingUserService;
	
	UserResponseDTO userResponseDTO;
	
	@PostMapping("/TrainBooking/Login")
	public ResponseEntity<UserResponseDTO> Authenticate(@RequestBody UserRequestDTO userRequestDTO){	
		
		return trainBookingUserService.AthenticateUser(userRequestDTO);
	}
	
	@PostMapping("/TrainBooking/Registry")
	public ResponseEntity<UserResponseDTO> RegistrationUser(@RequestBody UserDTO user){
	
		return trainBookingUserService.UserRegistration(user);
	
	}
	
	@GetMapping("/TrainBooking/User/{UserId}")
	public ResponseEntity<UserDTO> GetUserById(@PathVariable Integer UserId) {
		
		return trainBookingUserService.getUserById(UserId); 
	}
}
