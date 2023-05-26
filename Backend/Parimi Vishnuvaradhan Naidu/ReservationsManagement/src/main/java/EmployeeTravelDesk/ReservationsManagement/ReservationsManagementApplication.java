package com.EmployeeTravelDesk.ReservationsManagement;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationDocs;
import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationTypes;
import com.EmployeeTravelDesk.ReservationsManagement.Entities.Reservations;
import com.EmployeeTravelDesk.ReservationsManagement.Repositories.ReservationDocsRepo;
import com.EmployeeTravelDesk.ReservationsManagement.Repositories.ReservationTypesRepo;
import com.EmployeeTravelDesk.ReservationsManagement.Repositories.ReservationsRepo;
import com.EmployeeTravelDesk.ReservationsManagement.Services.ReservationTypesServices;
import com.EmployeeTravelDesk.ReservationsManagement.Services.ReservationsServices;

@SpringBootApplication
public class ReservationsManagementApplication implements CommandLineRunner{
	
	@Autowired
	ReservationsServices reservationsServices;
	
	@Autowired
	ReservationTypesServices reservationTypesServices;

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(ReservationsManagementApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		
 
		ReservationTypes obj2= reservationTypesServices.findReservationType("bus");
		//System.out.println(reservationType);
		Reservations obj=new Reservations(1, 2,obj2,LocalDate.now(), "hello", LocalDate.now(),100,"he10","ghsdgjh");
		reservationsServices.addReservation(obj);
		System.out.println(reservationsServices.getReservationsByTravelRequestId(2));
	}

}
