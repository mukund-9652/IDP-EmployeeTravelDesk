package com.EmployeeTravelDesk.ReservationsManagement.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationTypes;

public interface ReservationTypesRepo extends  JpaRepository<ReservationTypes,Integer> {

	public ReservationTypes findByTypeName(String typeName);

	
}
