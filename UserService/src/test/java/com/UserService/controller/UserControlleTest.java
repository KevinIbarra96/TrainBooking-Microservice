package com.UserService.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.UserService.demo.controller.UserController;
import com.UserService.demo.dto.UserDTO;
import com.UserService.demo.dto.UserRequestDTO;
import com.UserService.demo.dto.UserResponseDTO;
import com.UserService.demo.repo.UserRepo;
import com.UserService.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes =UserController.class)
public class UserControlleTest {
	
	@MockBean
	UserService userService;
	
	@Mock
	UserRepo userRepo;
	
	@Autowired
	MockMvc mockMvc;
	
	UserRequestDTO userRequestDTO;
	UserDTO userDTO;
	UserResponseDTO userResponseDTO;
	
	@BeforeEach
	public void setUp() {
		userRequestDTO = new UserRequestDTO(1,"Kevin","123456780");
		
		userResponseDTO = new UserResponseDTO("Login Successful",200);
		userResponseDTO.setUserId(1);
		
		userDTO = new UserDTO(1, "Kevin9", "kevin@gmail.com", "75162168");
		userDTO.setPassword("new password");
		
	}
	
	@Test
	public void LoginTest() throws Exception {
		
		when(userService.AuthenticateUser(any(UserRequestDTO.class))).thenReturn(userResponseDTO);
		
		MvcResult result = mockMvc.perform(post("/users/Login").content(asJsonString(userRequestDTO)).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())		
			.andExpect(jsonPath("$.statusCode").value(200))
			.andExpect(jsonPath("$.message").value("Login Successful"))
			.andExpect(jsonPath("$.userId").value(1)).andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
		System.out.println(responseBody);
		
	}
	
	@Test
	public void RegistryTest() throws Exception {
		
		userResponseDTO.setMessage("User Saved Successfully");
		
		when(userService.UserRegistrationM(any(UserDTO.class))).thenReturn(userResponseDTO);		
		
		MvcResult result = mockMvc.perform(post("/users/Registry").content(asJsonString2(userDTO)).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.statusCode").value(200))
			.andExpect(jsonPath("$.message").value("User Saved Successfully"))
			.andExpect(jsonPath("$.userId").value(1)).andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
		System.out.println(responseBody);
		
	}
	
	@Test
	public void GetUserByIdTest() throws Exception {
		
		when(userService.getUserById(1)).thenReturn(userDTO);
		
		MvcResult result = mockMvc.perform(get("/users/{UserId}",1))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.userId").value(1))
				.andExpect(jsonPath("$.username").value("Kevin9"))
				.andExpect(jsonPath("$.password").value("Password no avaible"))
				.andExpect(jsonPath("$.email").value("kevin@gmail.com"))
				.andExpect(jsonPath("$.phone").value("75162168"))
				.andExpect(jsonPath("$.userId").value(1))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
		System.out.println(responseBody);
		
	}
	
	
	@Test
	public void LoginTestException() throws Exception {
		
		userRequestDTO.setUserName("");
		userRequestDTO.setPassword("");
		when(userService.AuthenticateUser(any(UserRequestDTO.class))).thenReturn(userResponseDTO);
		
		MvcResult result = mockMvc.perform(post("/users/Login").content(asJsonString(userRequestDTO)).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.statusCode").value("MA400"))
			.andExpect(jsonPath("$.message").value("Invalid Arguments Passed")).andReturn();
		
		//mockMvc.perform(asyncDispatch(result));
		String responseBody = result.getResponse().getContentAsString();
		
		System.out.println(responseBody);
		
	}	

	private String asJsonString(UserRequestDTO userDTO2) {

		try {
			return new ObjectMapper().writeValueAsString(userDTO2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String asJsonString2(UserDTO userDTO2) {

		try {
			return new ObjectMapper().writeValueAsString(userDTO2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
