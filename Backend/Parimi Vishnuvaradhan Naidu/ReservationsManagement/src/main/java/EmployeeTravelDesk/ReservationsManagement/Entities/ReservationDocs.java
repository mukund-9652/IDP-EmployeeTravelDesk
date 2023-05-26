package com.EmployeeTravelDesk.ReservationsManagement.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class ReservationDocs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="reservationid")
	private Reservations reservationid;
	
	private String documentURl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reservations getReservationid() {
		return reservationid;
	}

	public void setReservationid(Reservations reservationid) {
		this.reservationid = reservationid;
	}

	public String getDocumentURl() {
		return documentURl;
	}

	public void setDocumentURl(String documentURl) {
		this.documentURl = documentURl;
	}

	public ReservationDocs(){
		
	}
	public ReservationDocs(Reservations reservationid, String documentURl) {
		super();
		this.reservationid = reservationid;
		this.documentURl = documentURl;
	}

	@Override
	public String toString() {
		return "ReservationDocs [reservationid=" + reservationid + ", documentURl=" + documentURl + "]";
	}
	
	
	

}
