package com.EmployeeTravelDesk.ReservationsManagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.Reservations;
import com.EmployeeTravelDesk.ReservationsManagement.Exceptions.CustomException;
import com.EmployeeTravelDesk.ReservationsManagement.Services.ReservationsServices;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
	@Autowired
	private ReservationsServices reservationServices;
	
	@PostMapping(path="/add", consumes="application/json")
	public void addReservation(@RequestBody Reservations reservations) {
		this.reservationServices.addReservation(reservations);
	}
	
	@GetMapping("/track/{travelRequestId}")
	public List<Reservations> getReservationsByTravelRequestId(@PathVariable long travelRequestId) throws CustomException{
		return this.reservationServices.getReservationsByTravelRequestId(travelRequestId);
	}
	
	@GetMapping("/{id}")
	public Reservations getReservationsById(@PathVariable int id) {
		return this.reservationServices.getReservationsById(id);
	}
}
