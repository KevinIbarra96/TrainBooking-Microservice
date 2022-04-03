package com.TrainBooking.app.dto;

import java.util.List;

public class TrainBookingResponseDTO {


	private UserDTO user;
	private List<TrainBookingDTO> trainBooking;

	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	public List<TrainBookingDTO> getTrainBooking() {
		return trainBooking;
	}


	public void setTrainBooking(List<TrainBookingDTO> trainBooking) {
		this.trainBooking = trainBooking;
	}
	
		
	
	
}
