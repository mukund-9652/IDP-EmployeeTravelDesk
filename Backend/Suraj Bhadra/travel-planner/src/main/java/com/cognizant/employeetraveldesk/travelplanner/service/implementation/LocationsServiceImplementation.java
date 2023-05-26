package com.cognizant.employeetraveldesk.travelplanner.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.travelplanner.mapper.ModelMapper;
import com.cognizant.employeetraveldesk.travelplanner.model.LocationsDTO;
import com.cognizant.employeetraveldesk.travelplanner.repository.LocationsRepository;
import com.cognizant.employeetraveldesk.travelplanner.service.LocationsService;

@Service
public class LocationsServiceImplementation implements LocationsService {

	//inject an instance of the LocationsRepository class into the current class.
	@Autowired
	private LocationsRepository locationsRepository;

	private ModelMapper modelMapper= new ModelMapper();
	
	@Override
	public List<LocationsDTO> returnAllLocations() {
		// TODO Auto-generated method stub
		List<LocationsDTO> resultLocations=modelMapper.convertEntityToDTO(locationsRepository.findAll());
		return resultLocations;
	}

}
