package com.TrainBooking.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.TrainBooking.app.dto.TravelDTO;


@FeignClient(name = "TRAVELSERVICE")
public interface TravelClient {

	@GetMapping("/travels/{travelId}")
	public ResponseEntity<TravelDTO> getTravelById(@PathVariable(name = "travelId") Integer travelId);
	
}
