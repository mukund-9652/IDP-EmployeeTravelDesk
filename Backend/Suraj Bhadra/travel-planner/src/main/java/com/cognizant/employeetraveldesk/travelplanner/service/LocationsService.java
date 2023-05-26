package com.cognizant.employeetraveldesk.travelplanner.service;

import java.util.List;

import com.cognizant.employeetraveldesk.travelplanner.model.LocationsDTO;

public interface LocationsService {
	//to return all locations
	List<LocationsDTO> returnAllLocations();
}
