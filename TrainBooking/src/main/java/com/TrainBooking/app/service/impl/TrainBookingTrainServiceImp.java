package com.TrainBooking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TrainBooking.app.client.TrainClient;
import com.TrainBooking.app.dto.TrainDetailsResponseDto;
import com.TrainBooking.app.entity.Booking;
import com.TrainBooking.app.repo.BookingRepo;
import com.TrainBooking.app.service.TrainBookingTrainService;

@Service
public class TrainBookingTrainServiceImp implements TrainBookingTrainService{
	
	@Autowired
	TrainClient trainClient;
	
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

		List<Booking> bookingList = new ArrayList<Booking>();
		for(int i=0; i<bookingRequestDto.getPassengerList().size(); i++) {
			Booking booking = new Booking();
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
