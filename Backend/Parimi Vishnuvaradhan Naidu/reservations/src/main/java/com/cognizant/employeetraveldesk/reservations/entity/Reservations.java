package com.cognizant.employeetraveldesk.reservations.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "reservationdonebyemployeeid")
	private int reservationDoneByEmployeeId;

	@Column(name = "travelrequestid")
	private int travelRequestId;

	@ManyToOne
	@JoinColumn(name = "reservationtypeid")
	private ReservationTypes reservationTypes;

	
	private LocalDate createdOn;
	private String reservationDoneWithEntity;
	private LocalDate ReservationDate;
	private int amount;
	private String confirmationId;
	private String remarks;
	
	
	@PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }
}
