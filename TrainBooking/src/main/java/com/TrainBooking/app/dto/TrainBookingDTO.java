package com.TrainBooking.app.dto;

import java.time.LocalDateTime;

public class TrainBookingDTO {

	private Integer bookingId;
	private String bookingticket;
	private LocalDateTime dateTime;
	private Integer tavelId;
	private TravelDTO travel;
	private String passengerName;
	private String passengerEmail;
	private String passengerPhone;
	

	public TrainBookingDTO(Integer bookingId, String bookingticket, LocalDateTime dateTime, Integer tavelId,
			TravelDTO travel, String passengerName, String passengerEmail, String passengerPhone) {
		super();
		this.bookingId = bookingId;
		this.bookingticket = bookingticket;
		this.dateTime = dateTime;
		this.tavelId = tavelId;
		this.travel = travel;
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.passengerPhone = passengerPhone;
	}
	public Integer getTavelId() {
		return tavelId;
	}
	public void setTavelId(Integer tavelId) {
		this.tavelId = tavelId;
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
	public TravelDTO getTravel() {
		return travel;
	}
	public void setTravel(TravelDTO travel) {
		this.travel = travel;
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
