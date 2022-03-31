package com.TrainBooking.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(FeignException.class)
//	public ResponseEntity<ErrorResponse> handleException(FeignException ex){
//		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),"F500");
//		
//		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.OK);
//	}
	
}
