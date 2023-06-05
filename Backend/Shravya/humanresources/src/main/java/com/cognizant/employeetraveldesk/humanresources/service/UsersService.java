package com.cognizant.employeetraveldesk.humanresources.service;

import java.util.List;

import com.cognizant.employeetraveldesk.humanresources.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.humanresources.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.humanresources.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.humanresources.model.UsersDTO;

public interface UsersService {
	List<UsersDTO> getEmployees() throws ResourceNotFoundException;
	boolean addEmployee(UsersDTO usersDTO) throws DuplicateResourceException, InvalidResourceException;
	boolean deleteEmployeeById(int userId) throws ResourceNotFoundException;
	boolean updateEmployee(int id, UsersDTO usersDTO) throws ResourceNotFoundException;
	UsersDTO getEmployeeById(int userId) throws ResourceNotFoundException;
}
