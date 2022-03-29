package com.TrainBooking.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TrainBooking.app.client.TrainClient;
import com.TrainBooking.app.dto.BookingRequestDto;
import com.TrainBooking.app.dto.ResponseDto;
import com.TrainBooking.app.dto.TrainDetailsResponseDto;
import com.TrainBooking.app.entity.booking;
import com.TrainBooking.app.repo.BookingRepo;
import com.TrainBooking.app.service.TrainBookingTrainService;

@Service
public class TrainBookingTrainServiceImp implements TrainBookingTrainService{
	
	@Autowired
	TrainClient trainClient;
	
	@Autowired
	BookingRepo bookingRepo;
	
	@Override
	public ResponseEntity<TrainDetailsResponseDto> getTrainById(Integer trainId) {		
		return trainClient.getTrainById(trainId);
	}

	@Override
	public ResponseDto bookTravel(List<BookingRequestDto> bookingRequestDtoList) {
		// Verificamos que user exista
		
		// Verificamos que travel exista
		
		// Modificamos List BookingRequestDto a List<Booking>
		List<booking> bookingList = new ArrayList<booking>();
		for(int i=0; i<bookingRequestDtoList.size(); i++) {
			booking booking = new booking();
			BeanUtils.copyProperties(bookingRequestDtoList.get(i), booking);
			bookingList.add(booking);
		}
		
		bookingRepo.saveAll(bookingList);
		return new ResponseDto("Travel Booked", "TB-200");
	}

}
