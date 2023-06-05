package com.cognizant.employeetraveldesk.humanresouces.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.employeetraveldesk.humanresouces.Exception.GradeUpdationException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.InvalidEmailException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.InvalidEmployeeIdException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.UserAlreadyExistException;
import com.cognizant.employeetraveldesk.humanresouces.Exception.UserNotFoundException;
import com.cognizant.employeetraveldesk.humanresouces.entities.Users;
import com.cognizant.employeetraveldesk.humanresouces.service.UsersService;

@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees")
	public List<Users> getAllUsers() {

		return this.usersService.getAllEmployees();

	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employee/{id}")
	public Users getEmployeeById(@PathVariable long id) {
		try {
			return this.usersService.getEmployeeById(id);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/employees", consumes = "application/json")
	public String insertEmployee(@RequestBody Users user)
			throws UserAlreadyExistException, InvalidEmployeeIdException, InvalidEmailException {
		try {
			return this.usersService.insertEmployee(user);
		} catch (UserAlreadyExistException e) {
			e.printStackTrace();
			return "Error: User already exists";
		}

		catch (InvalidEmployeeIdException e) {
			e.printStackTrace();
			return "Error: Invalid employee id";
		} catch (InvalidEmailException e) {
			e.printStackTrace();
			return "Error: Invalid email id";
		}

	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/employees/{employeeId}")
	public ResponseEntity<String> updateEmployee(@RequestBody Users user, @PathVariable long employeeId) throws GradeUpdationException {
	    try {
	        this.usersService.updateEmployee(user, employeeId);
	        return ResponseEntity.ok().body("{\"message\": \"Updation successful\"}");
	    } catch (GradeUpdationException e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Grade should not be downgraded\"}");
	    }
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeById(@PathVariable long id) throws UserNotFoundException {
		try {
			this.usersService.deleteEmployeeById(id);
		} catch (UserNotFoundException e) {
			e.printStackTrace();

		}

	}

}
