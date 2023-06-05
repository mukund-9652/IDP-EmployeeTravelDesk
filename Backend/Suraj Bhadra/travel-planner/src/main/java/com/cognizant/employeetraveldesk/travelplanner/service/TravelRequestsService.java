package com.cognizant.employeetraveldesk.travelplanner.service;

import com.cognizant.employeetraveldesk.reservations.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.travelplanner.model.TravelRequestsDTO;

public interface TravelRequestsService {
	//to insert a new travel request
	int createTravelRequest(TravelRequestsDTO travelRequestsDTO) throws DuplicateResourceException, InvalidResourceException;
	//to return a request using hr id
	TravelRequestsDTO retrieveTravelRequestByHRid(int HRid) throws ResourceNotFoundException;
	//to return a request using request id
	TravelRequestsDTO retrieveTravelRequestById(int trid) throws ResourceNotFoundException;
	//to update a travel request
	boolean updateTravelRequestsById(int trid,TravelRequestsDTO travelRequestsDTO) throws ResourceNotFoundException, InvalidResourceException;
}
