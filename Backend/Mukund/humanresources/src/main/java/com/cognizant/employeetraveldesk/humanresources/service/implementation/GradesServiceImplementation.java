package com.cognizant.employeetraveldesk.humanresources.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.humanresources.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.humanresources.mapper.ModelMapperList;
import com.cognizant.employeetraveldesk.humanresources.model.GradesDTO;
import com.cognizant.employeetraveldesk.humanresources.repository.GradesRepository;
import com.cognizant.employeetraveldesk.humanresources.service.GradesService;

@Service
public class GradesServiceImplementation implements GradesService {

	@Autowired
	GradesRepository gradesRepository;
	ModelMapperList modelMapperList=new ModelMapperList();
	@Override
	public List<GradesDTO> getGradesList() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<GradesDTO> gradesDTO=new ArrayList<GradesDTO>();
		gradesDTO=modelMapperList.mapGradesToGradesDto(gradesRepository.findAll());
		
		if(gradesDTO.size()==0) {
			throw new ResourceNotFoundException("No Resource in Grades. Check your Database!");
		}
		
		return gradesDTO;
	}

}
