package com.cognizant.employeetraveldesk.reimbursement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.cognizant.employeetraveldesk.reimbursement.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.reimbursement.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.reimbursement.model.ReimbursementRequestsDTO;
import com.cognizant.employeetraveldesk.reimbursement.service.implementation.ReimbursementRequestsServiceImpl;

@Validated
@RestController
@RequestMapping("/api/reimbursements")
@CrossOrigin(origins ="http://localhost:4200")
public class ReimbursementRequestsController {
		
	@Autowired
	ReimbursementRequestsServiceImpl reimbursementRequestsServiceImpl;

	@GetMapping("/{travelrequestid}/requests")
	public List<ReimbursementRequestsDTO> getReimbursementRequests(@PathVariable Integer travelrequestid) {
		// This Returns the list of reimbursement requests DTO for the requested travel
		// id
		return reimbursementRequestsServiceImpl.readAllRequestsForTravelRequestId(travelrequestid);
	}

	@GetMapping("/{reimbursementid}")
	public ReimbursementRequestsDTO getReimbursement(@PathVariable Integer reimbursementid) {
		// This Returns the reimbursement request DTO for the given reimbursement id
		return reimbursementRequestsServiceImpl.readRequestByReimbursementId(reimbursementid);
	}

	@PostMapping("/add")
	public ResponseEntity<Void> createReimbursement(@Valid @RequestBody ReimbursementRequestsDTO request) throws DuplicateResourceException, InvalidResourceException {
		// This returns the status code if the reimbursement request is created or not
		boolean requestStatusCheck = reimbursementRequestsServiceImpl.createRequest(request);
		if (requestStatusCheck) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/{reimbursementid}/process")
	public ResponseEntity<Void> putReimbursement(@PathVariable Integer reimbursementid,
			@Valid @RequestBody  ReimbursementRequestsDTO request) {
		// This
		// This returns the status code if the reimbursement request is updated or not

		boolean requestStatusCheck = reimbursementRequestsServiceImpl.updateRequest(request);
		if (requestStatusCheck) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
