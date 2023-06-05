package com.cognizant.employeetraveldesk.humanresouces.service;

import java.util.List;

import com.cognizant.employeetraveldesk.humanresouces.Exception.GradeUpdationException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.InvalidEmailException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.InvalidEmployeeIdException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.UserAlreadyExistException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.UserNotFoundException;
import com.cognizant.employeetraveldesk.humanresouces.entities.Users;

public interface UsersService {

	List<Users> getAllEmployees();

	String updateEmployee(Users user, long id) throws GradeUpdationException;

	Users getEmployeeById(long id) throws UserNotFoundException;

	String insertEmployee(Users user)
			throws UserAlreadyExistException, InvalidEmployeeIdException, InvalidEmailException;

	void deleteEmployeeById(long id) throws UserNotFoundException;

}
