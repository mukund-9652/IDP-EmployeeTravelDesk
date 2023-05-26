package com.EmployeeTravelDesk.ReservationsManagement;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationTypes;
import com.EmployeeTravelDesk.ReservationsManagement.Entities.Reservations;
import com.EmployeeTravelDesk.ReservationsManagement.Services.ReservationTypesServices;
import com.EmployeeTravelDesk.ReservationsManagement.Services.ReservationsServices;

@SpringBootApplication
public class ReservationsManagementApplication implements CommandLineRunner {

	@Autowired
	ReservationsServices reservationsServices;

	@Autowired
	ReservationTypesServices reservationTypesServices;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ReservationsManagementApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		ReservationTypes obj2 = reservationTypesServices.findReservationType("bus");
		// System.out.println(reservationType);
		Reservations obj = new Reservations(2262989, 23456, obj2, LocalDate.now(), "Employee", LocalDate.now(), 100,
				"23456", "NULL");
		reservationsServices.addReservation(obj);
		System.out.println(reservationsServices.getReservationsByTravelRequestId(2));
	}

}
