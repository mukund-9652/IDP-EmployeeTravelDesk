package com.EmployeeTravelDesk.ReservationsManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationTypes;
import com.EmployeeTravelDesk.ReservationsManagement.Repositories.ReservationTypesRepo;

@Service
public class ReservationTypesServices {
	
	@Autowired 
	ReservationTypesRepo reservationTypesRepo;
	public ReservationTypes findReservationType(String typeName) {
		return reservationTypesRepo.findByTypeName(typeName);
	}
	public List<ReservationTypes> GetAllReservationTypes() {
		return (List<ReservationTypes>) reservationTypesRepo.findAll();
	}
}
