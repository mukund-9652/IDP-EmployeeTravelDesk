package com.cognizant.employeetraveldesk.travelplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeetraveldesk.travelplanner.model.TravelRequestsDTO;
import com.cognizant.employeetraveldesk.travelplanner.service.implementation.TravelRequestServiceImplementation;

@Validated
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/travelrequests")
public class TravelRequestsController {

	//inject an instance of the TravelRequestServiceImplementation class into the current class.
	@Autowired
	TravelRequestServiceImplementation travelRequestServiceImplementation;

	//insert new travel request
	@PostMapping("/new")
	public ResponseEntity<Integer> createTravelRequest(@RequestBody TravelRequestsDTO travelRequestDTO){
		
		int request=travelRequestServiceImplementation.createTravelRequest(travelRequestDTO);
		if(request>0) {
		return ResponseEntity.ok(request);
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//return all the pending requests using HR id
	@GetMapping("/{HRid}/pending")
	public TravelRequestsDTO retrieveTravelRequestByHRid(@PathVariable int HRid) {
		TravelRequestsDTO resultDTO=travelRequestServiceImplementation.retrieveTravelRequestByHRid(HRid);
		
		if(resultDTO!=null) {
			return resultDTO;
		}
		else {
			return null;
		}
	}
	
	//return a request using request id
	@GetMapping("/{trid}")
	public TravelRequestsDTO retrieveTravelRequestId(@PathVariable int trid) {
		TravelRequestsDTO resultDTO=travelRequestServiceImplementation.retrieveTravelRequestById(trid);
		
		if(resultDTO!=null) {
			return resultDTO;
		}
		else {
			return null;
		}
	}
	
	//update a travel request
	@PutMapping("/{trid}/update")
	public ResponseEntity<String> updateTravelRequestById(@PathVariable int trid, @RequestBody TravelRequestsDTO travelRequestsDTO){
		boolean result=travelRequestServiceImplementation.updateTravelRequestsById(trid, travelRequestsDTO);
		
		if(result) {
			return ResponseEntity.ok("Your travel request has been updated");
		}
		else {
			return ResponseEntity.internalServerError().build();
		}
	}

}
