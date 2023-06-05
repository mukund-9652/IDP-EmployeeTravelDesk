package com.cognizant.employeetraveldesk.humanresouces.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.humanresouces.entities.Grades;
import com.cognizant.employeetraveldesk.humanresouces.repos.GradesRepository;
import com.cognizant.employeetraveldesk.humanresouces.service.GradesService;
@Service
public class GradesServiceImpl implements GradesService {
	@Autowired
	GradesRepository repository;
	
	//f.returns grades list
	public List<Grades> getAllGrades() {
		return (List<Grades>) repository.findAll();
		
	}

}
