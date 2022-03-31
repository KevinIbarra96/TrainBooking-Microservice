package com.TrainBooking.app.exception;

public class ServerDownException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServerDownException(String message) {
		super(message);
	}
	
}
