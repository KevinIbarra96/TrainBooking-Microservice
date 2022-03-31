package com.TrainBooking.app.service;

import java.util.List;

import com.TrainBooking.app.dto.TrainBookingResponseDTO;

public interface TrainBookingService {

	List<TrainBookingResponseDTO> getBookingByUserId(Integer userId);
	List<TrainBookingResponseDTO> getBookingByUserIdResi(Integer userId);
}
