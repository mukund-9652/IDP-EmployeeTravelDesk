package com.cognizant.employeetraveldesk.reservations.service;

import java.util.List;

import com.cognizant.employeetraveldesk.reservations.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.reservations.model.ReservationsDTO;

public interface ReservationsService {
	boolean addReservation(ReservationsDTO reservationsDTO) throws DuplicateResourceException, InvalidResourceException;
	ReservationsDTO getReservationById(int reservationId) throws ResourceNotFoundException;
	List<ReservationsDTO> getAllReservationsByTravelRequestId(int travelRequestId) throws ResourceNotFoundException;
}
