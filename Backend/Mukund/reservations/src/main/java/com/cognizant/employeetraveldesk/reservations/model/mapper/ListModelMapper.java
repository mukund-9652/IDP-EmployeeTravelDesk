package com.cognizant.employeetraveldesk.reservations.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.employeetraveldesk.reservations.entity.ReservationDocs;
import com.cognizant.employeetraveldesk.reservations.entity.ReservationTypes;
import com.cognizant.employeetraveldesk.reservations.entity.Reservations;
import com.cognizant.employeetraveldesk.reservations.model.ReservationDocsDTO;
import com.cognizant.employeetraveldesk.reservations.model.ReservationTypesDTO;
import com.cognizant.employeetraveldesk.reservations.model.ReservationsDTO;

@Component
public class ListModelMapper {
	@Autowired
	ModelMapper modelMapper;

	public List<ReservationTypes> reservationTypesDTOToEntity(List<ReservationTypesDTO> reservationTypesDTO) {
		List<ReservationTypes> reservationTypes = new ArrayList<ReservationTypes>();
		for (ReservationTypesDTO types : reservationTypesDTO) {
			reservationTypes.add(modelMapper.reservationTypesDTOToEntity(types));
		}
		return reservationTypes;
	}

	public List<Reservations> reservationsDTOToEntity(List<ReservationsDTO> reservationsDTO){
		List<Reservations> reservations=new ArrayList<Reservations>();
		
		for (ReservationsDTO reservation : reservationsDTO) {
			reservations.add(modelMapper.reservationsDTOToEntity(reservation));
		}
		
		return reservations;
	}
	public List<ReservationDocs> reservationDocsDTOToEntity(List<ReservationDocsDTO> reservationDocsDTO){
		List<ReservationDocs> reservationDocs = new ArrayList<ReservationDocs>();
		
		for(ReservationDocsDTO reservationDocDTO: reservationDocsDTO) {
			reservationDocs.add(modelMapper.reservationDocsDTOToEntity(reservationDocDTO));
		}
		
		return reservationDocs;
	}

	public List<ReservationTypesDTO> reservationTypesEntityToDTO(List<ReservationTypes> reservationTypes) {
		List<ReservationTypesDTO> reservationTypesDTO = new ArrayList<ReservationTypesDTO>();
		for (ReservationTypes types : reservationTypes) {
			reservationTypesDTO.add(modelMapper.reservationTypesEntityToDTO(types));
		}
		return reservationTypesDTO;
	}

	public List<ReservationsDTO> reservationsEntityToDTO(List<Reservations> reservations){
		List<ReservationsDTO> reservationsDTO=new ArrayList<ReservationsDTO>();
		
		for (Reservations reservation : reservations) {
			reservationsDTO.add(modelMapper.reservationsEntityToDTO(reservation));
		}
		
		return reservationsDTO;
	}
	public List<ReservationDocsDTO> reservationDocsEntityToDTO(List<ReservationDocs> reservationDocs){
		List<ReservationDocsDTO> reservationDocsDTO = new ArrayList<ReservationDocsDTO>();
		
		for(ReservationDocs reservationDoc: reservationDocs) {
			reservationDocsDTO.add(modelMapper.reservationDocsEntityToDTO(reservationDoc));
		}
		
		return reservationDocsDTO;
	}
}
