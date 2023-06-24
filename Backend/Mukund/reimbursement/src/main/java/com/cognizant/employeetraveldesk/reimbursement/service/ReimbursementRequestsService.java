package com.cognizant.employeetraveldesk.reimbursement.service;

import java.util.List;

import com.cognizant.employeetraveldesk.reimbursement.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.reimbursement.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.reimbursement.model.ReimbursementRequestsDTO;

public interface ReimbursementRequestsService {

	/*
	 * ReimbursementRequestsService is the Service Layer for the Reimbursement
	 * Module The requirements include:
	 * 
	 * 1. Creating the new Reimbursement request and storing the values into the
	 * database
	 * 
	 * 2. Reading and retrieving the Reimbursement requests from the table
	 * Reimbursement Requests based on the given Travel Request Id
	 * 
	 * 3. Reading and retrieving the Reimbursement requests from the table
	 * Reimbursement Requests based on the given Reimbursement Request Id
	 * 
	 * 4. Processing the request
	 */

	// 1. Creating the new Reimbursement request and storing the values into the
	// database
	boolean createRequest(ReimbursementRequestsDTO request) throws DuplicateResourceException, InvalidResourceException;

	// * 2. Reading and retrieving the Reimbursement requests from the table
	// Reimbursement Requests based on the given Travel Request Id
	List<ReimbursementRequestsDTO> readAllRequestsForTravelRequestId(Integer id);

	// 3. Reading and retrieving the Reimbursement requests from the table
	// Reimbursement Requests based on the given Reimbursement Request Id
	ReimbursementRequestsDTO readRequestByReimbursementId(int id);

	// 4. Processing the request
	boolean updateRequest(ReimbursementRequestsDTO request);
	
	List<ReimbursementRequestsDTO> readRequestByEmployeeId(int id);

}
