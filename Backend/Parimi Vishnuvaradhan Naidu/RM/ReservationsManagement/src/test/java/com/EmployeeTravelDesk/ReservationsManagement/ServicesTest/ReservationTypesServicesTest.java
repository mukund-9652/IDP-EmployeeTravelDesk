package com.EmployeeTravelDesk.ReservationsManagement.ServicesTest;

import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationTypes;
import com.EmployeeTravelDesk.ReservationsManagement.Exceptions.CustomException;
import com.EmployeeTravelDesk.ReservationsManagement.Repositories.ReservationTypesRepo;
import com.EmployeeTravelDesk.ReservationsManagement.Services.ReservationTypesServices;

public class ReservationTypesServicesTest {

	@Autowired
	private ReservationTypesServices reservationTypesServices;

	@Autowired
	private ReservationTypesRepo reservationTypesRepo;

	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testFindReservationType() throws CustomException {
		String typeName = "Flight";

		// Create a mock ReservationTypes object
		ReservationTypes reservationType = mock(ReservationTypes.class);

		// Mock the findByTypeName method of the reservationTypesRepo
		when(reservationTypesRepo.findByTypeName(typeName)).thenReturn(reservationType);

		// Call the findReservationType method
		ReservationTypes result = reservationTypesServices.findReservationType(typeName);

		// Verify that the findByTypeName method was called
		verify(reservationTypesRepo).findByTypeName(typeName);

		// Verify the result
		assertEquals(reservationType, result);
	}

	@Test
	public void testGetAllReservationTypes() throws CustomException {
		// Create a list of mock ReservationTypes objects
		List<ReservationTypes> reservationTypesList = new ArrayList<>();
		ReservationTypes reservationType1 = mock(ReservationTypes.class);
		ReservationTypes reservationType2 = mock(ReservationTypes.class);
		reservationTypesList.add(reservationType1);
		reservationTypesList.add(reservationType2);

		// Mock the findAll method of the reservationTypesRepo
		when(reservationTypesRepo.findAll()).thenReturn(reservationTypesList);

		// Call the GetAllReservationTypes method
		List<ReservationTypes> result = reservationTypesServices.GetAllReservationTypes();

		// Verify that the findAll method was called
		verify(reservationTypesRepo).findAll();

		// Verify the result
		assertEquals(reservationTypesList, result);
	}
}
