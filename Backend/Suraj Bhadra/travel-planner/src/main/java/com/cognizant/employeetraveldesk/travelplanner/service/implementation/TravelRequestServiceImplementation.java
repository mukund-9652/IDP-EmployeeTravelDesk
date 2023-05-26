package com.cognizant.employeetraveldesk.travelplanner.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public int createTravelRequest(TravelRequestsDTO travelRequestsDTO) {
		// TODO Auto-generated method stub
		TravelRequests travelRequest=modelMapper.convertDTOToEntity(travelRequestsDTO);
		Optional<TravelRequests> checkTravelRequests=travelRequestsRepository.findById(travelRequest.getRequestId());
		if(checkTravelRequests.isPresent()) {
			return -1;
		}
		else {
			travelRequestsRepository.save(travelRequest);
			return travelRequest.getRequestId();
		}
	}
	@Override
	public TravelRequestsDTO retrieveTravelRequestByHRid(int HRid) {
		// TODO Auto-generated method stub
		TravelRequests checkTravelRequests=travelRequestsRepository.findByToBeApprovedByHRId(HRid);
		if(checkTravelRequests!=null) {
			return modelMapper.convertEntityToDTO(checkTravelRequests);
		}
		else {			
			return null;
		}
	}
	@Override
	public TravelRequestsDTO retrieveTravelRequestById(int trid) {
		// TODO Auto-generated method stub
		Optional<TravelRequests> checkTravelRequests=travelRequestsRepository.findById(trid);
		if(checkTravelRequests.isPresent()) {
			return modelMapper.convertEntityToDTO(checkTravelRequests.get());
		}
		else {			
			return null;
		}
	}
	@Override
	public boolean updateTravelRequestsById(int trid, TravelRequestsDTO travelRequestsDTO) {
		// TODO Auto-generated method stub
		Optional<TravelRequests> checkTravelRequests=travelRequestsRepository.findById(trid);
		if(checkTravelRequests.isPresent()) {
			boolean check=travelRequestsRepository.save(modelMapper.convertDTOToEntity(travelRequestsDTO)) != null;
			return check;
		}
		else {			
			return false;
		}
	}

}
