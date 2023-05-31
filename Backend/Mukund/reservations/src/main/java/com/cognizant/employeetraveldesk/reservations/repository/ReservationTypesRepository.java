package com.cognizant.employeetraveldesk.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.employeetraveldesk.reservations.entity.ReservationTypes;

public interface ReservationTypesRepository extends JpaRepository<ReservationTypes, Integer> {

}
