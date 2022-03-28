package com.TrainBooking.app.dto;

public class TrainDetailsResponseDto extends ResponseDto{

	private TrainDetailsDto data;

	public TrainDetailsResponseDto(String message, String statusCode) {
		super(message, statusCode);
	}

	public TrainDetailsDto getData() {
		return data;
	}

	public void setData(TrainDetailsDto data) {
		this.data = data;
	}
	
}
