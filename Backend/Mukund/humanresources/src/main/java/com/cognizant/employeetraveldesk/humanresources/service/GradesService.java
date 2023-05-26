package com.cognizant.employeetraveldesk.humanresources.service;

import java.util.List;

import com.cognizant.employeetraveldesk.humanresources.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.humanresources.model.GradesDTO;

public interface GradesService {
	List<GradesDTO> getGradesList() throws ResourceNotFoundException;
}
