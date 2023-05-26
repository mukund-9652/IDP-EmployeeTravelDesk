package com.cognizant.employeetraveldesk.reservations.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservations {

	private Integer id;
	private int reservationDoneByEmployeeId;
	private int travelRequestId;
	private ReservationTypes reservationTypes;
	private LocalDate createdOn;
	private String reservationDoneWithEntity;
	private LocalDate ReservationDate;
	private int amount;
	private String confirmationId;
	private String remarks;
}
