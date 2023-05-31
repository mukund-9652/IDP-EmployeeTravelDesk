//package com.EmployeeTravelDesk.ReservationsManagement.ServicesTest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.text.ParseException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.Order;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationTypes;
//import com.EmployeeTravelDesk.ReservationsManagement.Entities.Reservations;
//import com.EmployeeTravelDesk.ReservationsManagement.Exceptions.CustomException;
//import com.EmployeeTravelDesk.ReservationsManagement.Repositories.ReservationsRepo;
//import com.EmployeeTravelDesk.ReservationsManagement.Services.ReservationsServices;
//
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//
//public class ReservationsServicesTest {
//
//	@Autowired
//	private ReservationsServices reservationsServices;
//
//	@Mock
//	private ReservationsRepo reservationsRepo;
//
//	@Before
//	public void setup() {
//		MockitoAnnotations.openMocks(this);
//	}
//	
//	@Order(1)
//	@Test
//	public void testAddReservation() throws ParseException {
////		ReservationTypes obj = ReservationsServices.getReservationTypeId(1);
//		Reservations reservations = new Reservations();
//		reservations.setId(1);
//		reservations.setReservationsDoneByEmployeeId(2262981);
//		reservations.setTravelRequestId(1);
////		reservations.setReservationTypeId(obj);
//		reservations.setCreatedOn(LocalDate.now());
//		reservations.setReservationDoneWithEntity("Employee");
//		reservations.setReservationDate(LocalDate.now());
//		reservations.setAmount(899);
//		reservations.setConfirmationID("2552023");
//		reservations.setRemarks("NULL");
//	
//		
//	}
//
//	@Test
//	public void testGetReservationsByTravelRequestId() throws CustomException {
//		long travelRequestId = 123;
//
//		// Create a list of mock Reservations objects
//		List<Reservations> reservationsList = new ArrayList<>();
//		Reservations reservation1 = mock(Reservations.class);
//		Reservations reservation2 = mock(Reservations.class);
//		reservationsList.add(reservation1);
//		reservationsList.add(reservation2);
//
//		// Mock the findByTravelRequestId method of the reservationsRepo
//		when(reservationsRepo.findByTravelRequestId(travelRequestId)).thenReturn(reservationsList);
//
//		// Call the getReservationsByTravelRequestId method
////		List<Reservations> result = reservationsServices.getReservationsByTravelRequestId(travelRequestId);
//
//		// Verify that the findByTravelRequestId method was called
//
//		// Verify the result
////		assertEquals(reservationsList, result);
//	}
//	
//	@Test
//	public void testGetReservationsById() {
//		int id = 1;
//
//		// Create a mock Reservations object
//		Reservations reservation = mock(Reservations.class);
//
//		// Mock the findById method of the reservationsRepo
//		when(reservationsRepo.findById(id)).thenReturn(Optional.of(reservation));
//
//		// Call the getReservationsById method
////		Reservations result = reservationsServices.getReservationsById(id);
//
//		// Verify that the findById method was called
//
//		// Verify the result
////		assertEquals(reservation, result);
//	}
//}
//
