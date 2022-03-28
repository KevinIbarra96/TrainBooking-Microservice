package com.UserService.demo.service;

import com.UserService.demo.dto.UserDTO;
import com.UserService.demo.dto.UserRequestDTO;
import com.UserService.demo.dto.UserResponseDTO;

public interface UserService {

	UserResponseDTO AuthenticateUser(UserRequestDTO userRequestDTO);

	UserResponseDTO UserRegistrationM(UserDTO user);

	UserDTO getUserById(Integer userId);

}
