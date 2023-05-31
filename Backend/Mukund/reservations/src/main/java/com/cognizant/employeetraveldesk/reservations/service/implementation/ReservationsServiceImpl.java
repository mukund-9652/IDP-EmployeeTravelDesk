package com.cognizant.employeetraveldesk.reservations.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.reservations.entity.Reservations;
import com.cognizant.employeetraveldesk.reservations.model.ReservationsDTO;
import com.cognizant.employeetraveldesk.reservations.model.mapper.ListModelMapper;
import com.cognizant.employeetraveldesk.reservations.model.mapper.ModelMapper;
import com.cognizant.employeetraveldesk.reservations.repository.ReservationsRepository;
import com.cognizant.employeetraveldesk.reservations.service.ReservationsService;

@Service
public class ReservationsServiceImpl implements ReservationsService {

	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ListModelMapper listModelMapper;
	
	@Override
	public boolean addReservation(ReservationsDTO reservationsDTO) {
		// TODO Auto-generated method stub
		Optional<Reservations> checkReservation=reservationsRepository.findById(reservationsDTO.getId());
		if(checkReservation.isPresent()) {
			return false;
		}
		reservationsRepository.save(modelMapper.reservationsDTOToEntity(reservationsDTO));
		return true;
	}

	@Override
	public ReservationsDTO getReservationById(int reservationId) {
		// TODO Auto-generated method stub
		Optional<Reservations> checkReservation=reservationsRepository.findById(reservationId);
		if(checkReservation.isPresent()) {
			return modelMapper.reservationsEntityToDTO(checkReservation.get());
		}
		return null;
	}

	@Override
	public List<ReservationsDTO> getAllReservationsByTravelRequestId(int travelRequestId) {
		// TODO Auto-generated method stub
		List<Reservations> checkReservations=reservationsRepository.findAllByTravelRequestId(travelRequestId);
		if(!checkReservations.isEmpty()) {
			return listModelMapper.reservationsEntityToDTO(checkReservations);
		}
		return null;
	}

}
