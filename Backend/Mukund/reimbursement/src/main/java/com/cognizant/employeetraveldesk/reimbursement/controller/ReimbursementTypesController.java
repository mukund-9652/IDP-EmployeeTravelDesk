package com.cognizant.employeetraveldesk.reimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeetraveldesk.reimbursement.model.ReimbursementTypesDTO;
import com.cognizant.employeetraveldesk.reimbursement.service.implementation.ReimbursementTypesServiceImpl;

@Validated
@RestController
@RequestMapping("/api/reimbursements")
@CrossOrigin(origins="http://localhost:4200")
public class ReimbursementTypesController {
	@Autowired
	ReimbursementTypesServiceImpl reimbursementTypesServiceImpl;

	@GetMapping("/types")
	public List<ReimbursementTypesDTO> getReimbursementTypes() {
		// This Returns a list of ReimbursementTypes
		return reimbursementTypesServiceImpl.readAllTypes();
	}
}
