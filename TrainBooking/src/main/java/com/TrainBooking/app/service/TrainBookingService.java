package com.TrainBooking.app.service;

import java.util.List;

import com.TrainBooking.app.dto.TrainBookingResponseDTO;

public interface TrainBookingService {

	TrainBookingResponseDTO getBookingByUserId(Integer userId);
	TrainBookingResponseDTO getBookingByUserIdResi(Integer userId);
}
