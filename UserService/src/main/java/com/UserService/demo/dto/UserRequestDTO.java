package com.UserService.demo.dto;

import javax.validation.constraints.NotEmpty;

public class UserRequestDTO {
	
	private Integer userId;
	@NotEmpty(message ="User name should not be empty")
	private String username;
	@NotEmpty(message = "password field should not be empty")
	private String password;
	
	
	public UserRequestDTO(Integer userId, String username,String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
