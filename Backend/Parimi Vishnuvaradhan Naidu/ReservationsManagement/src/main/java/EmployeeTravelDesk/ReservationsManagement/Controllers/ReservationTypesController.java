package com.EmployeeTravelDesk.ReservationsManagement.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationTypes;
import com.EmployeeTravelDesk.ReservationsManagement.Services.ReservationTypesServices;

@RestController
public class ReservationTypesController {
	@Autowired
	private ReservationTypesServices reservationTypesServices;
	@GetMapping("/types")
	public List<ReservationTypes> getAllReservationTypes() {
		return this.reservationTypesServices.GetAllReservationTypes();
		
		
	}
	
	
	

}
