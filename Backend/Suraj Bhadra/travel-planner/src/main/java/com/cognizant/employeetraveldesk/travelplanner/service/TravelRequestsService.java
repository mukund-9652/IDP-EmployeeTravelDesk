package com.cognizant.employeetraveldesk.travelplanner.service;

import com.cognizant.employeetraveldesk.travelplanner.model.TravelRequestsDTO;

public interface TravelRequestsService {
	//to insert a new travel request
	int createTravelRequest(TravelRequestsDTO travelRequestsDTO);
	//to return a request using hr id
	TravelRequestsDTO retrieveTravelRequestByHRid(int HRid);
	//to return a request using request id
	TravelRequestsDTO retrieveTravelRequestById(int trid);
	//to update a travel request
	boolean updateTravelRequestsById(int trid,TravelRequestsDTO travelRequestsDTO);
}
