package com.cognizant.employeetraveldesk.reservations.model.mapper;

import org.springframework.stereotype.Component;

import com.cognizant.employeetraveldesk.reservations.entity.ReservationDocs;
import com.cognizant.employeetraveldesk.reservations.entity.ReservationTypes;
import com.cognizant.employeetraveldesk.reservations.entity.Reservations;
import com.cognizant.employeetraveldesk.reservations.model.ReservationDocsDTO;
import com.cognizant.employeetraveldesk.reservations.model.ReservationTypesDTO;
import com.cognizant.employeetraveldesk.reservations.model.ReservationsDTO;

@Component
public class ModelMapper {
	public ReservationTypesDTO reservationTypesEntityToDTO(ReservationTypes reservationTypes) {
		ReservationTypesDTO reservationTypesDTO=new ReservationTypesDTO(
				reservationTypes.getTypeId(),
				reservationTypes.getTypeName()
				);
		return reservationTypesDTO;
	}
	public ReservationTypes reservationTypesDTOToEntity(ReservationTypesDTO reservationTypesDTO) {
		ReservationTypes reservationTypes=new ReservationTypes(
				reservationTypesDTO.getTypeId(),
				reservationTypesDTO.getTypeName()
				);
		return reservationTypes;
	}
	public ReservationsDTO reservationsEntityToDTO(Reservations reservations) {
		ReservationsDTO reservationsDTO=new ReservationsDTO(
				reservations.getId(),
				reservations.getReservationDoneByEmployeeId(),
				reservations.getTravelRequestId(),
				this.reservationTypesEntityToDTO(reservations.getReservationTypes()),
				reservations.getCreatedOn(),
				reservations.getReservationDoneWithEntity(),
				reservations.getReservationDate(),
				reservations.getAmount(),
				reservations.getConfirmationId(),
				reservations.getRemarks()
				);
		return reservationsDTO;	
	}
	public Reservations reservationsDTOToEntity(ReservationsDTO reservationsDTO) {
		Reservations reservations=new Reservations(
				reservationsDTO.getId(),
				reservationsDTO.getReservationDoneByEmployeeId(),
				reservationsDTO.getTravelRequestId(),
				this.reservationTypesDTOToEntity(reservationsDTO.getReservationTypes()),
				reservationsDTO.getCreatedOn(),
				reservationsDTO.getReservationDoneWithEntity(),
				reservationsDTO.getReservationDate(),
				reservationsDTO.getAmount(),
				reservationsDTO.getConfirmationId(),
				reservationsDTO.getRemarks()
				);
		return reservations;
	}
	
	public ReservationDocs reservationDocsDTOToEntity(ReservationDocsDTO reservationsDocsDTO) {
		ReservationDocs reservationDocs=new ReservationDocs(
				reservationsDocsDTO.getId(),
				this.reservationsDTOToEntity(reservationsDocsDTO.getReservation()),
				reservationsDocsDTO.getDocumentURL()
				);
		return reservationDocs;
	}

	public ReservationDocsDTO reservationDocsEntityToDTO(ReservationDocs reservationsDocs) {
		ReservationDocsDTO reservationDocsDTO=new ReservationDocsDTO(
				reservationsDocs.getId(),
				this.reservationsEntityToDTO(reservationsDocs.getReservation()),
				reservationsDocs.getDocumentURL()
				);
		return reservationDocsDTO;
	}
}
