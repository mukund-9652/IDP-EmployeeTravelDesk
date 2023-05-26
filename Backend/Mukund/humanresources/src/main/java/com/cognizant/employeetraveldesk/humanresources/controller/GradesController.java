package com.cognizant.employeetraveldesk.humanresources.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeetraveldesk.humanresources.model.GradesDTO;
import com.cognizant.employeetraveldesk.humanresources.service.GradesService;

@Validated
@RestController
@RequestMapping("/api/grades")
public class GradesController {

	@Autowired
	GradesService gradesService;

	@GetMapping("")
	public List<GradesDTO> getGradesList() {
		return gradesService.getGradesList();
	}
}
