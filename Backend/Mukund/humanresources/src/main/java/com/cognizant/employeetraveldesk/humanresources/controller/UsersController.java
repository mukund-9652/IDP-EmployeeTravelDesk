package com.cognizant.employeetraveldesk.humanresources.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeetraveldesk.humanresources.model.UsersDTO;
import com.cognizant.employeetraveldesk.humanresources.service.implementation.UsersServiceImplementation;

@Validated
@RestController
@RequestMapping("/api/employees")
public class UsersController {

	@Autowired
	UsersServiceImplementation userServiceImplementation;

	@GetMapping("")
	public List<UsersDTO> getEmployees() {
		return userServiceImplementation.getEmployees();
	}

	@GetMapping("/{id}")
	public UsersDTO getEmployee(@PathVariable int id) {
		return userServiceImplementation.getEmployeeById(id);
	}
	
	@PostMapping("")
	public ResponseEntity<Void> addEmployee(@Valid @RequestBody UsersDTO usersDTO){
		boolean requestStatusCheck = userServiceImplementation.addEmployee(usersDTO);
		if (requestStatusCheck) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateEmployee(@PathVariable int id, @Valid @RequestBody UsersDTO usersDTO) {
		boolean requestStatusCheck = userServiceImplementation.updateEmployee(id,usersDTO);
		if (requestStatusCheck) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		boolean requestStatusCheck = userServiceImplementation.deleteEmployeeById(id);
		if (requestStatusCheck) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
