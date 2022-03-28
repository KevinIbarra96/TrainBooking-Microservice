package com.UserService.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserService.demo.dto.UserDTO;
import com.UserService.demo.dto.UserRequestDTO;
import com.UserService.demo.dto.UserResponseDTO;
import com.UserService.demo.service.UserService;
import com.UserService.demo.constant.ApiConstants;
import com.UserService.demo.exception.ErrorResponse;
import com.UserService.demo.exception.UserNotFoundException;
import com.UserService.demo.exception.UserPasswordIncorrectException;
import com.UserService.demo.exception.ValidationErrorResponse;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/Login")	
	public ResponseEntity<UserResponseDTO> Login(@Valid @RequestBody UserRequestDTO userRequestDTO) {
		UserResponseDTO userResponseDTO = userService.AuthenticateUser(userRequestDTO);			
		return new ResponseEntity<UserResponseDTO>(userResponseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/Registry")
	public ResponseEntity<UserResponseDTO> UserRegistration(@Valid @RequestBody UserDTO user){
		UserResponseDTO userResponseDTO = userService.UserRegistrationM(user);
		
		return new ResponseEntity<UserResponseDTO> (userResponseDTO,HttpStatus.OK); 
		
	}
	
	@GetMapping("/User/{UserId}")
	public ResponseEntity<UserDTO> GetUserById(@PathVariable Integer UserId) {
		UserDTO userDTO = userService.getUserById(UserId);
		userDTO.setPassword("Password no avaible");
		return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK); 
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerException(UserNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),ApiConstants.USER_NOT_FOUND);
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.OK);
		
	}
	
	@ExceptionHandler(UserPasswordIncorrectException.class)
	public ResponseEntity<ErrorResponse> handlerPasswordException(UserPasswordIncorrectException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),ApiConstants.INCORRECT_PASSWORD);
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.OK);
	}
	
	//Handler all validation exceptions
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleExceptionVal(MethodArgumentNotValidException ex){
		ValidationErrorResponse errorResponse = new ValidationErrorResponse("Invalid Arguments Passed",ApiConstants.INVALID_ARGS);
		
		ex.getBindingResult().getFieldErrors().stream().forEach(error -> {
			errorResponse.getInvalidArguments().put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<ValidationErrorResponse>(errorResponse,HttpStatus.OK);
	}
	
	
}















