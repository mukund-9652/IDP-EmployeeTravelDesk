
package com.cognizant.employeetraveldesk.humanresources.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cognizant.employeetraveldesk.humanresouces.entities.Grades;
import com.cognizant.employeetraveldesk.humanresouces.entities.Users;
import com.cognizant.employeetraveldesk.humanresouces.repos.UsersRepository;
import com.cognizant.employeetraveldesk.humanresouces.serviceimpl.UsersServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UsersServiceImpl.class)
public class UsersServiceImplTest {
	
	@InjectMocks
	private UsersServiceImpl usersServiceImpl;
	
	@Mock
	private UsersRepository usersRepository;
	@BeforeClass
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void testInsertEmployee() {
		Grades grades=new Grades();
		grades.setId(1);
		grades.setName("Grade-01");
		Users user=new Users();
		user.setEmployeeId(3);
		user.setFirstName("Peddamallu");
		user.setLastName("Divya");
		user.setEmailAddress("Divya@gmail.com");
		user.setPhoneNumber("9775543675");
		user.setRoles("HR");
		user.setCurrentGradeId(grades);
		user.setAccessGranted(true);
		try {
		String message=usersServiceImpl.insertEmployee(user);
		assertEquals("User registered succesfully",message);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	

}