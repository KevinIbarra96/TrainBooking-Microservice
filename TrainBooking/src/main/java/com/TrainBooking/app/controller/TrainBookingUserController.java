package com.TrainBooking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TrainBooking.app.dto.UserResponseDTO;
import com.TrainBooking.app.exception.ErrorResponse;
import com.TrainBooking.app.exception.ServerDownException;
import com.TrainBooking.app.exception.UserNotFoundException;
import com.TrainBooking.app.service.TrainBookingUserService;
import com.TrainBooking.app.constant.ApiConstants;
import com.TrainBooking.app.dto.UserDTO;
import com.TrainBooking.app.dto.UserRequestDTO;

@RestController
public class TrainBookingUserController {
	
	@Autowired
	TrainBookingUserService trainBookingUserService;
	
	UserResponseDTO userResponseDTO;
	
	@PostMapping("/TrainBooking/Login")
	public ResponseEntity<UserResponseDTO> AthenticateUser(@RequestBody UserRequestDTO userRequestDTO){	
		
		return trainBookingUserService.AthenticateUserResi(userRequestDTO);
	}
	
	@PostMapping("/TrainBooking/Registry")
	public ResponseEntity<UserResponseDTO> RegistrationUser(@RequestBody UserDTO user){
	
		return trainBookingUserService.UserRegistration(user);
	
	}
	
	@GetMapping("/TrainBooking/User/{UserId}")
	public ResponseEntity<UserDTO> GetUserById(@PathVariable Integer UserId) {
		
		return trainBookingUserService.getUserById(UserId); 
	}
	
	@ExceptionHandler(ServerDownException.class)
	public ResponseEntity<ErrorResponse> handlerException(ServerDownException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),ApiConstants.SERVER_DOWM);
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.OK);
		
	}
}
