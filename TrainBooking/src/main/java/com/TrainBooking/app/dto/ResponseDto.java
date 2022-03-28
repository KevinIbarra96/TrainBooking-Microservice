package com.TrainBooking.app.dto;

public class ResponseDto {

	private String message;
	private String statusCode;
	
	public ResponseDto(String message, String statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
}
