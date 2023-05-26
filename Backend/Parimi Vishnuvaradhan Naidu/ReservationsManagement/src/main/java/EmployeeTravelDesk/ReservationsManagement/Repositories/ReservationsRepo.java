package com.EmployeeTravelDesk.ReservationsManagement.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.Reservations;

@Repository
public interface ReservationsRepo extends  JpaRepository<Reservations,Integer> {

	List<Reservations> findByTravelRequestId(long travelRequestId);
	
}