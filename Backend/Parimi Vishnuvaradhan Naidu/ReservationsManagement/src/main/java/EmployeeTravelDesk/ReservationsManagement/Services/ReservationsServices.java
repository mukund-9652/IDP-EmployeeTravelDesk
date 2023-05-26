package com.EmployeeTravelDesk.ReservationsManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.Reservations;
import com.EmployeeTravelDesk.ReservationsManagement.Repositories.ReservationsRepo;

@Service
public class ReservationsServices {
	
	@Autowired
	ReservationsRepo reservationsRepo;
	
	public void addReservation(Reservations obj) {
		
		reservationsRepo.save(obj);
	}
	public List<Reservations> getReservationsByTravelRequestId(long travelRequestId){
		return reservationsRepo.findByTravelRequestId(travelRequestId);
	}
	
	public Reservations getReservationsById(int id) {
		return reservationsRepo.findById(id).get();
	}
	
	
	
	
}
