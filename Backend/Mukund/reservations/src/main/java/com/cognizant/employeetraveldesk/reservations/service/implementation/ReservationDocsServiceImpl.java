package com.cognizant.employeetraveldesk.reservations.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.reservations.entity.ReservationDocs;
import com.cognizant.employeetraveldesk.reservations.entity.Reservations;
import com.cognizant.employeetraveldesk.reservations.model.ReservationDocsDTO;
import com.cognizant.employeetraveldesk.reservations.model.mapper.ModelMapper;
import com.cognizant.employeetraveldesk.reservations.repository.ReservationDocsRepository;
import com.cognizant.employeetraveldesk.reservations.repository.ReservationsRepository;
import com.cognizant.employeetraveldesk.reservations.service.ReservationDocsService;

@Service	
public class ReservationDocsServiceImpl implements ReservationDocsService {
	
	@Autowired
	ReservationDocsRepository reservationDocsRepository;
	
	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public ReservationDocsDTO getReservationDocsById(int reservationId) {
		// TODO Auto-generated method stub
		Optional<Reservations> checkReservations=reservationsRepository.findById(reservationId);
		if(checkReservations.isPresent()) {
			ReservationDocs checkDocs=reservationDocsRepository.findByReservationid(checkReservations.get());
			if(checkDocs!=null) {
				return modelMapper.reservationDocsEntityToDTO(checkDocs);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

}
