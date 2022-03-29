package com.TrainBooking.app.dto;

import java.time.LocalDateTime;

public class BookingRequestDto {
	
	private String bookingticket;
	private LocalDateTime dateTime;
	private Integer userId;
	private Integer travelId;
	private String passengerName;
	private String passengerEmail;
	private String passengerPhone;
	
	public String getBookingticket() {
		return bookingticket;
	}
	public void setBookingticket(String bookingticket) {
		this.bookingticket = bookingticket;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
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
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getPassengerPhone() {
		return passengerPhone;
	}
	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

}
