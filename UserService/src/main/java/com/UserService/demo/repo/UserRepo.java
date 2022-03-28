package com.UserService.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.UserService.demo.dto.UserDTO;
import com.UserService.demo.dto.UserRequestDTO;
import com.UserService.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

	@Query("Select new com.UserService.demo.dto.UserRequestDTO(a.userId,a.username, a.password) from User a where a.username = :username")
	UserRequestDTO findByUsername(String username);
	
	@Query("Select new com.UserService.demo.dto.UserDTO(a.userId,a.username, a.email,a.phone) from User a where a.userId = :userId")
	UserDTO findByUserId(Integer userId);
	
}
