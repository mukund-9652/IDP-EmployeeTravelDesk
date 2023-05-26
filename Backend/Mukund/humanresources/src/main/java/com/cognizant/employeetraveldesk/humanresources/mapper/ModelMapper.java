package com.cognizant.employeetraveldesk.humanresources.mapper;

import com.cognizant.employeetraveldesk.humanresources.entity.Grades;
import com.cognizant.employeetraveldesk.humanresources.entity.GradesHistory;
import com.cognizant.employeetraveldesk.humanresources.entity.Users;
import com.cognizant.employeetraveldesk.humanresources.model.GradesDTO;
import com.cognizant.employeetraveldesk.humanresources.model.GradesHistoryDTO;
import com.cognizant.employeetraveldesk.humanresources.model.UsersDTO;

public class ModelMapper {
	public Grades mapGradesDtoToGrades(GradesDTO gradesDTO) {
		Grades grades=new Grades(
				gradesDTO.getId(),
				gradesDTO.getName()
				);
		return grades;
	}
	
	public GradesDTO mapGradesToGradesDto(Grades grades) {
		GradesDTO gradesDTO=new GradesDTO(
				grades.getId(),
				grades.getName()
				);
		return gradesDTO;
	}
	
	
	public Users mapUserDtoToUser(UsersDTO userDTO) {
		Users user=new Users(
				userDTO.getEmployeeid(),
				userDTO.getFirstName(),
				userDTO.getLastName(),
				userDTO.getPhoneNumber(),
				userDTO.getEmailAddress(),
				userDTO.getRole(),
				this.mapGradesDtoToGrades(userDTO.getGrades())
				);
		return user;
	}
	
	public UsersDTO mapUserToUserDto(Users user) {
		UsersDTO userDTO=new UsersDTO(
				user.getEmployeeid(),
				user.getFirstName(),
				user.getLastName(),
				user.getPhoneNumber(),
				user.getEmailAddress(),
				user.getRole(),
				this.mapGradesToGradesDto(user.getGrades())
				);
		return userDTO;
	}
	
	public GradesHistory mapGradesHistoryDtoToGradesHistory(GradesHistoryDTO gradesHistoryDTO) {
		GradesHistory gradesHistory=new GradesHistory(
					gradesHistoryDTO.getId(),
					gradesHistoryDTO.getAssignedOn(),
					this.mapUserDtoToUser(gradesHistoryDTO.getUsers()),
					this.mapGradesDtoToGrades(gradesHistoryDTO.getGrades())
				);
		
		return gradesHistory;
	}
	
	public GradesHistoryDTO mapGradesHistoryToGradesHistoryDTO(GradesHistory gradesHistory) {
		GradesHistoryDTO gradesHistoryDTO=new GradesHistoryDTO(
					gradesHistory.getId(),
					gradesHistory.getAssignedOn(),
					this.mapUserToUserDto(gradesHistory.getEmployeeid()),
					this.mapGradesToGradesDto(gradesHistory.getGrades())
				);
		
		return gradesHistoryDTO;
	}
	
}
