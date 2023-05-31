package com.cognizant.employeetraveldesk.reservations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeetraveldesk.reservations.model.ReservationTypesDTO;
import com.cognizant.employeetraveldesk.reservations.service.implementation.ReservationTypesServiceImpl;

@Validated
@RestController
@RequestMapping("/api/reservations/")
public class ReservationTypesController {
	
	@Autowired
	ReservationTypesServiceImpl reservationTypesServiceImpl;
	
	@GetMapping("/types")
	public List<ReservationTypesDTO> getReservationTypes(){
		return reservationTypesServiceImpl.getReservationTypes();
	}
}
