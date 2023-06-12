package com.cognizant.employeetraveldesk.travelplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeetraveldesk.travelplanner.model.LocationsDTO;
import com.cognizant.employeetraveldesk.travelplanner.service.implementation.LocationsServiceImplementation;

@Validated
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/travelrequests")
public class LocationsController {
	
	//inject an instance of the LocationsServiceImplementation class into the current class.
	@Autowired
	LocationsServiceImplementation locationsServiceImplementation;
	
	//return all locations
	@GetMapping("/locations")
	public List<LocationsDTO> getLocations() {
		// This Returns a list of ReimbursementTypes
		return locationsServiceImplementation.returnAllLocations();
	}
}
