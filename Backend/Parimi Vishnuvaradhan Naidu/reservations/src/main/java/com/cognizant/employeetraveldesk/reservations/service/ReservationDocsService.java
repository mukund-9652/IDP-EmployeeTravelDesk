package com.cognizant.employeetraveldesk.reservations.service;

import com.cognizant.employeetraveldesk.reservations.model.ReservationDocsDTO;

public interface ReservationDocsService {
	ReservationDocsDTO getReservationDocsById(int reservationId);
}
