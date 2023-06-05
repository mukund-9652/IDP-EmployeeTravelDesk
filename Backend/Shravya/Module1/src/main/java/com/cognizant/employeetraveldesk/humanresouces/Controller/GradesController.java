package com.cognizant.employeetraveldesk.humanresouces.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeetraveldesk.humanresouces.entities.Grades;
import com.cognizant.employeetraveldesk.humanresouces.service.GradesService;

@RestController
public class GradesController {
	@Autowired
	private GradesService gradesService;
	
	@GetMapping("/grades")
	public List<Grades> getAllGrades(){
		return this.gradesService.getAllGrades();
		
	}

}
