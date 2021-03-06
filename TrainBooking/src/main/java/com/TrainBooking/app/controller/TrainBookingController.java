package com.TrainBooking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.TrainBooking.app.constant.ApiConstants;
import com.TrainBooking.app.dto.TrainBookingResponseDTO;
import com.TrainBooking.app.exception.ErrorResponse;
import com.TrainBooking.app.exception.ServerDownException;
import com.TrainBooking.app.exception.UserNotFoundException;
import com.TrainBooking.app.service.TrainBookingService;

@RestController
@Validated
public class TrainBookingController {

	@Autowired
	TrainBookingService trainBookingService;
		
	@GetMapping("/TrainBooking/GetBooking/{userId}")
	public ResponseEntity<TrainBookingResponseDTO> getBookingByUserId( @PathVariable Integer userId){		
		
		TrainBookingResponseDTO trainBookingResponseDTO = trainBookingService.getBookingByUserIdResi(userId);
		return new ResponseEntity<TrainBookingResponseDTO>(trainBookingResponseDTO,HttpStatus.OK);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerException(UserNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),ApiConstants.USER_NOT_FOUND);
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.OK);
		
	}
	@ExceptionHandler(ServerDownException.class)
	public ResponseEntity<ErrorResponse> handlerException(ServerDownException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),ApiConstants.SERVER_DOWM);
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.OK);
		
	}
	
}
