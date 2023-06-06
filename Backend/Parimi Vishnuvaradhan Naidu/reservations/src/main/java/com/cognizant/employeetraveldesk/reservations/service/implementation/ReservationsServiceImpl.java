package com.cognizant.employeetraveldesk.reservations.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.reservations.entity.Reservations;
import com.cognizant.employeetraveldesk.reservations.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.ResourceNotFoundException;
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
	public boolean addReservation(ReservationsDTO reservationsDTO)  throws DuplicateResourceException, InvalidResourceException {
		// TODO Auto-generated method stub
		Optional<Reservations> checkReservation=reservationsRepository.findById(reservationsDTO.getId());
		if(checkReservation.isPresent()) {
			throw new DuplicateResourceException("Data already found for id "+reservationsDTO.getId()+". So try with new ID.");
		}
		if(!checkReservationDateFromTravelPlanner(reservationsDTO.getReservationDate(), reservationsDTO.getReservationTypesDTO().getTypeName())) {
			return false;
		}
		reservationsRepository.save(modelMapper.reservationsDTOToEntity(reservationsDTO));
		return true;
	}

	@Override
	public ReservationsDTO getReservationById(int reservationId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Reservations> checkReservation=reservationsRepository.findById(reservationId);
		if(checkReservation.isPresent()) {
			return modelMapper.reservationsEntityToDTO(checkReservation.get());
		}
		throw new ResourceNotFoundException("Resource not found for id "+reservationId);
	}

	@Override
	public List<ReservationsDTO> getAllReservationsByTravelRequestId(int travelRequestId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<Reservations> checkReservations=reservationsRepository.findAllByTravelRequestId(travelRequestId);
		if(!checkReservations.isEmpty()) {
			return listModelMapper.reservationsEntityToDTO(checkReservations);
		}
		throw new ResourceNotFoundException("Resource not found for id "+travelRequestId);
	}
	
	private boolean checkReservationDateFromTravelPlanner(LocalDate reservationDate, String reservationTypes) throws InvalidResourceException {
		LocalDate travelPlannerReservationDate = LocalDate.now();
		if(reservationTypes.equalsIgnoreCase("train") || reservationTypes.equalsIgnoreCase("bus") ) {
			if(travelPlannerReservationDate.compareTo(reservationDate)!=1) {
				throw new InvalidResourceException("Reservation Date in travel planner is "+reservationDate+" so reservation date must be one day before it.");
			}
		}
		else if(reservationTypes.equalsIgnoreCase("hotel")) {
			if(travelPlannerReservationDate.compareTo(reservationDate)!=0) {
				throw new InvalidResourceException("Reservation Date in travel planner is "+reservationDate+" so reservation date must be one day before it.");
			}
		}
		return true;
	}
}
