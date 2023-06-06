package com.cognizant.employeetraveldesk.reservations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.employeetraveldesk.reservations.entity.Reservations;

public interface ReservationsRepository extends JpaRepository<Reservations,Integer> {
	List<Reservations> findAllByTravelRequestId(int travelRequestId);
}
