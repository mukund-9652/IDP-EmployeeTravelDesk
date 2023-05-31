package com.EmployeeTravelDesk.ReservationsManagement.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.Reservations;
import com.EmployeeTravelDesk.ReservationsManagement.Exceptions.CustomException;
import com.EmployeeTravelDesk.ReservationsManagement.Exceptions.InvalidReservationDateException;
import com.EmployeeTravelDesk.ReservationsManagement.Repositories.ReservationsRepo;

@Service
public class ReservationsServices {
	
	@Autowired
	ReservationsRepo reservationsRepo;
	
	public boolean addReservation(Reservations obj) {
		try {
			Date reservationDate = null;
			Date fromDate = null;
			if (reservationDate.compareTo(fromDate)<=0) {
				throw new InvalidReservationDateException("Invalid Date for Reservation");
			}
		}
			catch (InvalidReservationDateException ex) {
				System.out.println(ex);
				return false;
			}
		
		reservationsRepo.save(obj);
		return true;
	}
	
	public List<Reservations> getReservationsByTravelRequestId(long travelRequestId) throws CustomException {
		List<Reservations> reservations = reservationsRepo.findByTravelRequestId(travelRequestId);
		return reservations;
			
	}
	
	public Reservations getReservationsById(int id) {
		return reservationsRepo.findById(id).get();
	}
	
	
	
	
}
