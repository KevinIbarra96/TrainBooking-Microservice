package com.TrainBooking.app.dto;

import java.util.List;

public class BookingRequestDto {
	private Integer userId;
	private Integer travelId;
	private List<PassengerDto> passengerList;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTravelId() {
		return travelId;
	}
	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
	}
	public List<PassengerDto> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<PassengerDto> passengerList) {
		this.passengerList = passengerList;
	}

}
