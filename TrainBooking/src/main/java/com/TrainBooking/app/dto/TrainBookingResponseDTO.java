package com.TrainBooking.app.dto;

import java.time.LocalDateTime;

public class TrainBookingResponseDTO {

	private Integer bookingId;
	private String bookingticket;
	private LocalDateTime dateTime;
	private UserDTO user;
	private TravelDTO travel;
	private String passengerName;
	private String passengerEmail;
	private String passengerPhone;
	
	public TrainBookingResponseDTO() {
		
	}
	
	public TrainBookingResponseDTO(Integer bookingId, String bookingticket, LocalDateTime dateTime, String passengerName, String passengerEmail, String passengerPhone) {
		super();
		this.bookingId = bookingId;
		this.bookingticket = bookingticket;
		this.dateTime = dateTime;			
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.passengerPhone = passengerPhone;
	}
	
	public TravelDTO getTravel() {
		return travel;
	}

	public void setTravel(TravelDTO travel) {
		this.travel = travel;
	}

	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
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
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
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
