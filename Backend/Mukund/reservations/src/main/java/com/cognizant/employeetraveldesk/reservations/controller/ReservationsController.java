package com.cognizant.employeetraveldesk.reservations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeetraveldesk.reservations.model.ReservationsDTO;
import com.cognizant.employeetraveldesk.reservations.service.implementation.ReservationsServiceImpl;

@Validated
@RestController
@RequestMapping("/api/reservations")
public class ReservationsController {
	@Autowired
	ReservationsServiceImpl reservationsServiceImpl;
	
	@GetMapping("/track/{travelRequestId}")
	public List<ReservationsDTO> getReservationsByTravelRequestId(@PathVariable int travelRequestId){
		return reservationsServiceImpl.getAllReservationsByTravelRequestId(travelRequestId);
	}
	@GetMapping("/{reservationId}")
	public ReservationsDTO getReservationsById(@PathVariable int reservationId){
		return reservationsServiceImpl.getReservationById(reservationId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> addReservatios(@RequestBody ReservationsDTO reservationsDTO){
		boolean requestStatusCheck = reservationsServiceImpl.addReservation(reservationsDTO);
		if (requestStatusCheck) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}