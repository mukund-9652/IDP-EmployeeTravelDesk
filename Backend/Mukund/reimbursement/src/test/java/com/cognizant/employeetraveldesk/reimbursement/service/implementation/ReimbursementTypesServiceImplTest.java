package com.cognizant.employeetraveldesk.reimbursement.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.employeetraveldesk.reimbursement.entity.ReimbursementTypes;
import com.cognizant.employeetraveldesk.reimbursement.repository.ReimbursementTypesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReimbursementTypesServiceImplTest {

	@InjectMocks
	private ReimbursementTypesServiceImpl reimbursementTypesServiceImpl;

	@Mock
	private ReimbursementTypesRepository reimbursementTypesRepository;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/*
	 * This test is to check the output from the service layer of Reimbursement
	 * Types
	 */
	
	@Test
	public void retrieveListOfTypesTest() {
		
		List<ReimbursementTypes> expectedTypes = new ArrayList<>(
				Arrays.asList(new ReimbursementTypes(1, "Food"), new ReimbursementTypes(2, "Water"),
						new ReimbursementTypes(3, "Laundry"), new ReimbursementTypes(4, "Local Travel")));

		when(reimbursementTypesRepository.saveAll(expectedTypes)).thenReturn(expectedTypes);

		List<ReimbursementTypes> actualTypes = reimbursementTypesRepository.findAll();

		verify(reimbursementTypesRepository).findAll();
		assertEquals(reimbursementTypesServiceImpl.readAllTypes(), actualTypes);
	}
}
