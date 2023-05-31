package com.cognizant.employeetraveldesk.reservations.service;

import java.util.List;

import com.cognizant.employeetraveldesk.reservations.model.ReservationsDTO;

public interface ReservationsService {
	boolean addReservation(ReservationsDTO reservationsDTO);
	ReservationsDTO getReservationById(int reservationId);
	List<ReservationsDTO> getAllReservationsByTravelRequestId(int travelRequestId);
}
