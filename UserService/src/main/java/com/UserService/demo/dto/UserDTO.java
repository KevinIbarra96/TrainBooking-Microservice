package com.UserService.demo.dto;

import javax.validation.constraints.NotEmpty;

public class UserDTO {
	
	private Integer userId;
	@NotEmpty(message ="User Name should not be emty")
	private String username;
	@NotEmpty(message ="User password should not be emty")
	private String password;
	@NotEmpty(message ="User email should not be emty")
	private String email;
	@NotEmpty(message ="User phone should not be emty")
	private String phone;
	
	public UserDTO(Integer userId, String username,	String email, String phone) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
