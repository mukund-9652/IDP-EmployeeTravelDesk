package com.cognizant.employeetraveldesk.humanresources.mapper;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.employeetraveldesk.humanresources.entity.Grades;
import com.cognizant.employeetraveldesk.humanresources.entity.GradesHistory;
import com.cognizant.employeetraveldesk.humanresources.entity.Users;
import com.cognizant.employeetraveldesk.humanresources.model.GradesDTO;
import com.cognizant.employeetraveldesk.humanresources.model.GradesHistoryDTO;
import com.cognizant.employeetraveldesk.humanresources.model.UsersDTO;

public class ModelMapperList {
	ModelMapper mapper=new ModelMapper();
	public List<Grades> mapGradesDtoToGrades(List<GradesDTO> gradesDTO) {
		List<Grades> grades=new ArrayList<Grades>();
		for(GradesDTO gradesChange:gradesDTO) {
			grades.add(mapper.mapGradesDtoToGrades(gradesChange));
		}
		return grades;
	}
	
	public List<GradesDTO> mapGradesToGradesDto(List<Grades> grades) {
		List<GradesDTO> gradesDTO=new ArrayList<GradesDTO>();
		for(Grades gradesChange:grades) {
			gradesDTO.add(mapper.mapGradesToGradesDto(gradesChange));
		}
		return gradesDTO;
	}
	
	
	public List<Users> mapUserDtoToUser(List<UsersDTO> usersDTO) {
		List<Users> users=new ArrayList<Users>();
		for(UsersDTO usersChange: usersDTO) {
			users.add(mapper.mapUserDtoToUser(usersChange));
		}
		return users;
	}
	
	public List<UsersDTO> mapUserToUserDto(List<Users> users) {
		List<UsersDTO> usersDTO=new ArrayList<UsersDTO>();
		for(Users usersChange: users) {
			usersDTO.add(mapper.mapUserToUserDto(usersChange));
		}
		return usersDTO;
	}
	
	public List<GradesHistory> mapGradesHistoryDtoToGradesHistory(List<GradesHistoryDTO> gradesHistoryDTO ) {
		List<GradesHistory> gradesHistory = new ArrayList<GradesHistory>();
		for(GradesHistoryDTO gradesHistoryChange: gradesHistoryDTO) {
			gradesHistory.add(mapper.mapGradesHistoryDtoToGradesHistory(gradesHistoryChange));
		}
		return gradesHistory;
	}
	
	public List<GradesHistoryDTO> mapGradesHistoryToGradesHistoryDto( List<GradesHistory> gradesHistory ) {
		List<GradesHistoryDTO> gradesHistoryDTO = new ArrayList<GradesHistoryDTO>();
		for(GradesHistory gradesHistoryChange: gradesHistory) {
			gradesHistoryDTO.add(mapper.mapGradesHistoryToGradesHistoryDTO(gradesHistoryChange));
		}
		return gradesHistoryDTO;
	}
	
}
