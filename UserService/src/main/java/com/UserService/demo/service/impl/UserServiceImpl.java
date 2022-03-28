package com.UserService.demo.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserService.demo.dto.UserDTO;
import com.UserService.demo.dto.UserRequestDTO;
import com.UserService.demo.dto.UserResponseDTO;
import com.UserService.demo.entity.User;
import com.UserService.demo.repo.UserRepo;
import com.UserService.demo.service.UserService;
import com.UserService.demo.exception.UserNotFoundException;
import com.UserService.demo.exception.UserPasswordIncorrectException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public UserResponseDTO AuthenticateUser(UserRequestDTO userRequestDTO){
		
		UserResponseDTO userResponseDTO;
		UserRequestDTO userDB = userRepo.findByUsername(userRequestDTO.getUserName());
		
		if(Objects.isNull(userDB)) {
			throw new UserNotFoundException("User "+ userRequestDTO.getUserName() +" not found");
		}
		if (!userDB.getPassword().equals(userRequestDTO.getPassword())) {
			throw new UserPasswordIncorrectException("Password incorrect: "+userRequestDTO.getUserName());
		}
		
		userResponseDTO = new UserResponseDTO("Login Successful", 200);
		System.out.print(userDB.getUserName());
		//User user = userDB;
		userResponseDTO.setUserId(userDB.getUserId());
		
		return userResponseDTO;
	}

	@Override
	public UserResponseDTO UserRegistrationM(UserDTO userDTO) {
		
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPhone(userDTO.getPhone());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		
		userRepo.save(user);
		UserResponseDTO userResponseDTO = new UserResponseDTO("User Saved Successfully", 200);
		userResponseDTO.setUserId(0);	
				
		return userResponseDTO;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		
		UserDTO userDTO = userRepo.findByUserId(userId);
		
		if(Objects.isNull(userDTO)) {
			throw new UserNotFoundException("User not found");
		}
		
		return userDTO;
	}
	
	
}
