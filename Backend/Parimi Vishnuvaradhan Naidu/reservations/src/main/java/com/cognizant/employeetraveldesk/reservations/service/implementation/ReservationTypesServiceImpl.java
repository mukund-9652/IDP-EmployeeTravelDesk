package com.cognizant.employeetraveldesk.reservations.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.reservations.model.ReservationTypesDTO;
import com.cognizant.employeetraveldesk.reservations.model.mapper.ListModelMapper;
import com.cognizant.employeetraveldesk.reservations.repository.ReservationTypesRepository;
import com.cognizant.employeetraveldesk.reservations.service.ReservationTypesService;

@Service
public class ReservationTypesServiceImpl implements ReservationTypesService {
	
	@Autowired
	ReservationTypesRepository reservationTypesRepository;

	@Autowired
	ListModelMapper listModelMapper;

	@Override
	public List<ReservationTypesDTO> getReservationTypes() {
		// TODO Auto-generated method stub
		
		return listModelMapper.reservationTypesEntityToDTO(reservationTypesRepository.findAll());
	}

}
