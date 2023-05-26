package com.cognizant.employeetraveldesk.reimbursement.service.implementation;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.reimbursement.entity.ReimbursementTypes;
import com.cognizant.employeetraveldesk.reimbursement.model.ReimbursementTypesDTO;
import com.cognizant.employeetraveldesk.reimbursement.repository.ReimbursementTypesRepository;
import com.cognizant.employeetraveldesk.reimbursement.service.ReimbursementTypesService;

@Service
public class ReimbursementTypesServiceImpl implements ReimbursementTypesService {

	@Autowired
	ReimbursementTypesRepository reimbursementTypesRepository;

	public ReimbursementTypesDTO mapEntityToDTO(ReimbursementTypes request) {
		ReimbursementTypesDTO resultDTO = new ReimbursementTypesDTO(request.getId(), request.getType());
		return resultDTO;
	}

	@Override
	public List<ReimbursementTypesDTO> readAllTypes() {
		// TODO Auto-generated method stub\
		List<ReimbursementTypes> resultEntity = reimbursementTypesRepository.findAll();
		List<ReimbursementTypesDTO> resultDTO=new ArrayList<ReimbursementTypesDTO>();
		for(ReimbursementTypes res:resultEntity) {
			resultDTO.add(mapEntityToDTO(res));
		}
		return resultDTO;
	}

}
