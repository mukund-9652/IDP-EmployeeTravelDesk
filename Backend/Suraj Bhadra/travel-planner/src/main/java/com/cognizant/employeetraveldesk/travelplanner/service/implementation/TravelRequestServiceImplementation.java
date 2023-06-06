package com.cognizant.employeetraveldesk.travelplanner.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.reservations.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.travelplanner.entity.TravelRequests;
import com.cognizant.employeetraveldesk.travelplanner.mapper.ModelMapper;
import com.cognizant.employeetraveldesk.travelplanner.model.TravelRequestsDTO;
import com.cognizant.employeetraveldesk.travelplanner.repository.TravelRequestsRepository;
import com.cognizant.employeetraveldesk.travelplanner.service.TravelRequestsService;

@Service
public class TravelRequestServiceImplementation implements TravelRequestsService {
	
	@Autowired
	private TravelRequestsRepository travelRequestsRepository;

	private ModelMapper modelMapper=new ModelMapper();
	
	@Override
	public int createTravelRequest(TravelRequestsDTO travelRequestsDTO) throws DuplicateResourceException, InvalidResourceException {
		// TODO Auto-generated method stub
		TravelRequests travelRequest=modelMapper.convertDTOToEntity(travelRequestsDTO);
		Optional<TravelRequests> checkTravelRequests=travelRequestsRepository.findById(travelRequest.getRequestId());
		if(checkTravelRequests.isPresent()) {
			throw new DuplicateResourceException(
					"Resource is already available for Id : " + travelRequest.getRequestId());
		}
		else {
			travelRequestsRepository.save(travelRequest);
			return travelRequest.getRequestId();
		}
	}
	@Override
	public TravelRequestsDTO retrieveTravelRequestByHRid(int HRid) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		TravelRequests checkTravelRequests=travelRequestsRepository.findByToBeApprovedByHRId(HRid);
		if(checkTravelRequests!=null) {
			return modelMapper.convertEntityToDTO(checkTravelRequests);
		}
		else {			
			throw new ResourceNotFoundException("Hr id not found");
		}
	}
	@Override
	public TravelRequestsDTO retrieveTravelRequestById(int trid) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		Optional<TravelRequests> checkTravelRequests=travelRequestsRepository.findById(trid);
		if(checkTravelRequests.isPresent()) {
			return modelMapper.convertEntityToDTO(checkTravelRequests.get());
		}
		else {			
			throw new ResourceNotFoundException("Travel Request Id not found");
		}
	}
	@Override
	public boolean updateTravelRequestsById(int trid, TravelRequestsDTO travelRequestsDTO) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<TravelRequests> checkTravelRequests=travelRequestsRepository.findById(trid);
		if(checkTravelRequests.isPresent()) {
			boolean check=travelRequestsRepository.save(modelMapper.convertDTOToEntity(travelRequestsDTO)) != null;
			return check;
		}
		else {			
			throw new ResourceNotFoundException("Travel Request Id not found");
		}
	}
}
