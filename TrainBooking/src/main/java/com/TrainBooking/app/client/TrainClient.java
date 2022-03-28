package com.TrainBooking.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.TrainBooking.app.dto.TrainDetailsResponseDto;


@FeignClient(name ="TRAINSERVICE")
public interface TrainClient {

	@GetMapping("/trains/{trainId}")
	public ResponseEntity<TrainDetailsResponseDto> getTrainById(@PathVariable Integer trainId);
	
	
}
