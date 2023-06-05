package com.cognizant.employeetraveldesk.humanresouces.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.humanresouces.Exception.GradeUpdationException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.InvalidEmailException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.InvalidEmployeeIdException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.UserAlreadyExistException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.UserNotFoundException;
import com.cognizant.employeetraveldesk.humanresouces.entities.Grades;
import com.cognizant.employeetraveldesk.humanresouces.entities.Users;
import com.cognizant.employeetraveldesk.humanresouces.repos.GradesHistoryRepository;
import com.cognizant.employeetraveldesk.humanresouces.repos.UsersRepository;
import com.cognizant.employeetraveldesk.humanresouces.service.UsersService;

@Service

public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	GradesHistoryRepository gradesHistoryRepository;

//A. Insert Employee  or D. update an employee
	public String insertEmployee(Users user)
			throws UserAlreadyExistException, InvalidEmployeeIdException, InvalidEmailException {
		if (usersRepository.existsById(user.getEmployeeId())) {
			throw new UserAlreadyExistException();
		}
		// Checking number of digits in employee id
		long num = user.getEmployeeId();
		int count = 0;
		while (num != 0) {
			num /= 10;

			count++;
		}
		// throwing exception if count is not equal to six
		if (count != 6) {

			throw new InvalidEmployeeIdException();
		}
		// checking if email is valid
		String email = user.getEmailAddress();
		if (!email.endsWith("@cognizant.com")) {
			throw new InvalidEmailException();
		}
		// if a new travel desk exe is added grade should be grade 1
		if (user.getRoles() == "TravelDeskExe") {
			Grades grade = new Grades();
			grade.setId(1);
			grade.setName("GRADE-1");
			user.setCurrentGradeId(null);
		}

		usersRepository.save(user);
		return "Success";
	}

	public String updateEmployee(Users user, long id) throws GradeUpdationException {
		Users user1 = new Users();
		user1 = usersRepository.findById(id).get();
		int Currentgrade = user1.getCurrentGradeId().getId();
		int Updatedgrade = user.getCurrentGradeId().getId();
		// grade should not be degraded
		if (Currentgrade < Updatedgrade) {
			throw new GradeUpdationException();
		}

		usersRepository.deleteById(id);
		usersRepository.save(user);
		return "Updation succesfull";
	}

	// B.Return an Employee list
	public List<Users> getAllEmployees() {
		return (List<Users>) usersRepository.findAll();
	}

	// c.Delete an employee
	public void deleteEmployeeById(long id) throws UserNotFoundException {
		if (!(usersRepository.existsById(id))) {
			throw new UserNotFoundException();
		}
		usersRepository.deleteById(id);
	}

	// e. return employee by id
	public Users getEmployeeById(long id) throws UserNotFoundException {
		if (!(usersRepository.existsById(id))) {
			throw new UserNotFoundException();
		}
		return usersRepository.findById(id).get();
	}

}
