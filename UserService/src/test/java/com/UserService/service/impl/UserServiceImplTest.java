package com.UserService.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.UserService.demo.dto.UserRequestDTO;
import com.UserService.demo.dto.UserResponseDTO;
import com.UserService.demo.exception.UserNotFoundException;
import com.UserService.demo.repo.UserRepo;
import com.UserService.demo.service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	UserRepo userRepo;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	UserRequestDTO userRequestDTO;
	
	@BeforeEach
	public void setUp() {
		userRequestDTO = new UserRequestDTO(1,"Kevin","kevin");
		
	}
	
	@Test
	@DisplayName("User Login")
	public void AuthenticateUserTest() {
		
		//userRepo.findByUsername
		when(userRepo.findByUsername("Kevin")).thenReturn(userRequestDTO);
		
		UserResponseDTO loginResult = userServiceImpl.AuthenticateUser(userRequestDTO);
		assertNotNull(loginResult);
		assertEquals(1, loginResult.getUserId());
		
	}
	
	@Test
	@DisplayName("User NotFound Exception")
	public void AuthenticateUserTestException() {
		
		//userRepo.findByUsername		
		when(userRepo.findByUsername("Kevin")).thenReturn(null);		
		
		assertThrows(UserNotFoundException.class, () -> userServiceImpl.AuthenticateUser(userRequestDTO));
		
	}
	
	
	
}
