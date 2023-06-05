package com.cognizant.employeetraveldesk.humanresources.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.cognizant.employeetraveldesk.humanresouces.entities.Grades;
import com.cognizant.employeetraveldesk.humanresouces.entities.Users;
import com.cognizant.employeetraveldesk.humanresouces.entities.GradeHistory;
import com.cognizant.employeetraveldesk.humanresouces.repos.GradesHistoryRepository;
import com.cognizant.employeetraveldesk.humanresouces.repos.GradesRepository;
import com.cognizant.employeetraveldesk.humanresouces.repos.UsersRepository;

@SpringBootTest
class Module1ApplicationTests {
	@Autowired
	ApplicationContext context;
	


	@Test
	public void createUser() {
		//GradesRepository gradesRepository=context.getBean(GradesRepository.class);
		Grades grades=new Grades();
		grades.setId(1);
		grades.setName("GRADE-01");
		//gradesRepository.save(grades);
		//UsersRepository usersRepository=context.getBean(UsersRepository.class);
		Users users=new Users();
		users.setEmployeeId(1);
		users.setFirstName("John");
		users.setLastName("Adams");
		users.setPhoneNumber("9987654325");
		users.setEmailAddress("John@gmail.com");
		users.setRoles("HR");
		users.setCurrentGradeId(grades);
		users.setAccessGranted(true);
		//usersRepository.save(users);
		GradesHistoryRepository gradesHistoryRepository=context.getBean(GradesHistoryRepository.class);
		GradeHistory gradeHistory=new GradeHistory();
		gradeHistory.setId(1);
		gradeHistory.setEmployeeId(users);
		gradeHistory.setGradeId(users.getCurrentGradeId());
		gradeHistory.setAssignedOn(java.time.LocalDate.now());
		gradesHistoryRepository.save(gradeHistory);
	

}}
