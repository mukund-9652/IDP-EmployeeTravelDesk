	package com.cognizant.employeetraveldesk.reimbursement.service;

import java.util.List;

import com.cognizant.employeetraveldesk.reimbursement.model.ReimbursementTypesDTO;

public interface ReimbursementTypesService {
	List<ReimbursementTypesDTO> readAllTypes();
}
