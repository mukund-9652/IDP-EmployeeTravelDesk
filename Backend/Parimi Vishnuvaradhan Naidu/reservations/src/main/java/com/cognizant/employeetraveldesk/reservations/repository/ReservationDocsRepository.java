package com.cognizant.employeetraveldesk.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.employeetraveldesk.reservations.entity.ReservationDocs;
import com.cognizant.employeetraveldesk.reservations.entity.Reservations;

public interface ReservationDocsRepository extends JpaRepository<ReservationDocs,Integer> {
	ReservationDocs findByReservationid(Reservations reservations);
}
