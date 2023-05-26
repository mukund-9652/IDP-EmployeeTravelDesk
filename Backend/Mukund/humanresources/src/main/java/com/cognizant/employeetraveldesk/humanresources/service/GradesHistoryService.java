package com.cognizant.employeetraveldesk.humanresources.service;

import com.cognizant.employeetraveldesk.humanresources.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.humanresources.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.humanresources.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.humanresources.model.UsersDTO;

public interface GradesHistoryService {
	void createGradesHistoryByEmployeeid(int employeeId) throws DuplicateResourceException, InvalidResourceException;
	boolean updateGradesHistoryByEmployeeId(int employeeId, UsersDTO updatedDTO)  throws ResourceNotFoundException;
}
