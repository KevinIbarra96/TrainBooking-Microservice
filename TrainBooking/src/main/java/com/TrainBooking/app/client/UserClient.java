package com.TrainBooking.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.TrainBooking.app.dto.UserResponseDTO;
import com.TrainBooking.app.dto.UserDTO;
import com.TrainBooking.app.dto.UserRequestDTO;

@FeignClient(name = "USERSERVICE")
public interface UserClient {
	
	@PostMapping("/users/Login")	
	public ResponseEntity<UserResponseDTO> Login(@RequestBody UserRequestDTO userRequestDTO);
	
	@PostMapping("/users/Registry")
	public ResponseEntity<UserResponseDTO> UserRegistration(@RequestBody UserDTO user);
	
	@GetMapping("/users/{UserId}")
	public ResponseEntity<UserDTO> GetUserById(@PathVariable Integer UserId);
	
}
