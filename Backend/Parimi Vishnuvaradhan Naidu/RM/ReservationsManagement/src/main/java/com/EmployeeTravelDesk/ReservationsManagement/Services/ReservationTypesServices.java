package com.EmployeeTravelDesk.ReservationsManagement.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationTypes;
import com.EmployeeTravelDesk.ReservationsManagement.Exceptions.CustomException;
import com.EmployeeTravelDesk.ReservationsManagement.Repositories.ReservationTypesRepo;

@Service
public class ReservationTypesServices {
	
	@Autowired 
	ReservationTypesRepo reservationTypesRepo;
	
	public ReservationTypes findReservationType(String typeName) throws CustomException {
		ReservationTypes reservationTypes = reservationTypesRepo.findByTypeName(typeName);
		if (reservationTypes == null)
			throw new CustomException("ReservationType not match with typeName"+ reservationTypes);
		
		return reservationTypes;
	}
	
	
	public List<ReservationTypes> GetAllReservationTypes() throws CustomException {
		List<ReservationTypes> reservationTypes = reservationTypesRepo.findAll();
		if (reservationTypes == null)
			throw new CustomException("ReservationTypes is Empty"+ reservationTypes);
		return reservationTypes;
	}
}
