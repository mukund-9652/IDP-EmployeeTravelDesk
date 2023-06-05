package com.cognizant.employeetraveldesk.humanresources.service.implementation;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.humanresources.entity.GradesHistory;
import com.cognizant.employeetraveldesk.humanresources.entity.Users;
import com.cognizant.employeetraveldesk.humanresources.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.humanresources.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.humanresources.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.humanresources.mapper.ModelMapper;
import com.cognizant.employeetraveldesk.humanresources.model.UsersDTO;
import com.cognizant.employeetraveldesk.humanresources.repository.GradesHistoryRepository;
import com.cognizant.employeetraveldesk.humanresources.repository.UsersRepository;
import com.cognizant.employeetraveldesk.humanresources.service.GradesHistoryService;

@Service
public class GradesHistoryServiceImplementation implements GradesHistoryService {

	@Autowired
	GradesHistoryRepository gradesHistoryRepository;

	@Autowired 
	UsersRepository usersRepository;

	ModelMapper modelMapper=new ModelMapper();

	@Override
	public boolean updateGradesHistoryByEmployeeId(int employeeId, UsersDTO updatedDTO) {
		// TODO Auto-generated method stub
		Optional<Users> checkData = usersRepository
				.findById(employeeId);
		
		Optional<GradesHistory> checkHistory=gradesHistoryRepository.findByEmployeeid(checkData.get());
		if(checkHistory.isPresent()) {
			if (checkData.isPresent()) {
				Users toUpdateUsers=checkData.get();
				boolean checkGrade= this.checkGrades(toUpdateUsers.getGrades().getName(),updatedDTO.getGrades().getName());
				if(checkGrade) {
					GradesHistory gradesHistory=checkHistory.get();
					gradesHistory.setAssignedOn(LocalDate.now());
					gradesHistory.setGrades(modelMapper.mapGradesDtoToGrades(updatedDTO.getGrades()));
					gradesHistoryRepository.save(gradesHistory);
					return true;
				}
				else {
					throw new InvalidResourceException("Cannot decrement grades");
				}
			}
			else {
				throw new ResourceNotFoundException("Employee Details Not found");
			}
		}
		else {
			throw new ResourceNotFoundException("History is not found. Check your Database");
		}
	}



	@Override
	public void createGradesHistoryByEmployeeid(int employeeId){
		// TODO Auto-generated method stub
		Optional<Users> checkData = usersRepository
				.findById(employeeId);
		
		Optional<GradesHistory> checkHistory=gradesHistoryRepository.findByEmployeeid(checkData.get());
		if(checkHistory.isPresent()) {
			throw new DuplicateResourceException("History already there for employee");
		}
		
		if (checkData.isPresent()) {
			Random random = new Random();
			GradesHistory gradesHistory=new GradesHistory(
					random.nextInt(1000000),
					LocalDate.now(),
					checkData.get(),
					checkData.get().getGrades()
					);
			gradesHistoryRepository.save(gradesHistory);
		} else {
			
			throw new ResourceNotFoundException("Employee Records not in Database");
		}
		
	}
	
	private boolean checkGrades(String grade1, String grade2) {
		if(grade1.equalsIgnoreCase("grade-1") && grade2.equalsIgnoreCase("grade-2")) {
			return false;
		}
		else if(grade1.equalsIgnoreCase("grade-1") && grade2.equalsIgnoreCase("grade-3")) {
			return false;
		}
		else if(grade1.equalsIgnoreCase("grade-2") && grade2.equalsIgnoreCase("grade-3")) {
			return false;
		}
		else {			
			return true;
		}
	}

}
