package com.TrainBooking.app.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TrainBooking.app.client.TrainClient;
import com.TrainBooking.app.client.UserClient;
import com.TrainBooking.app.dto.BookingRequestDto;
import com.TrainBooking.app.dto.ResponseDto;
import com.TrainBooking.app.dto.TrainDetailsResponseDto;
import com.TrainBooking.app.dto.UserDTO;
import com.TrainBooking.app.entity.booking;
import com.TrainBooking.app.repo.BookingRepo;
import com.TrainBooking.app.service.TrainBookingTrainService;

@Service
public class TrainBookingTrainServiceImp implements TrainBookingTrainService{
	
	@Autowired(required = false)
	TrainClient trainClient;
	
	@Autowired(required = false)
	UserClient userClient;
	
	@Autowired
	BookingRepo bookingRepo;
	
	@Override
	public ResponseEntity<TrainDetailsResponseDto> getTrainById(Integer trainId) {		
		return trainClient.getTrainById(trainId);
	}

	@Override
	public ResponseDto bookTravel(BookingRequestDto bookingRequestDto) {
		// Verificamos que user exista
		// ResponseEntity<UserDTO> userDto = userClient.GetUserById(1);
		
		// Verificamos que travel exista
		
		LocalDateTime currentDate = LocalDateTime.now();
		String bookingTicket = bookingRequestDto.getUserId() + "-" + bookingRequestDto.getTravelId();

		List<booking> bookingList = new ArrayList<booking>();
		for(int i=0; i<bookingRequestDto.getPassengerList().size(); i++) {
			booking booking = new booking();
			booking.setBookingticket(bookingTicket);
			booking.setDateTime(currentDate);
			booking.setUserId(bookingRequestDto.getUserId());
			booking.setTravelId(bookingRequestDto.getTravelId());
			
			BeanUtils.copyProperties(bookingRequestDto.getPassengerList().get(i), booking);
			bookingList.add(booking);
		}
		
		bookingRepo.saveAll(bookingList);
		return new ResponseDto("Travel Booked", "TB-200");
	}

}
