package com.EmployeeTravelDesk.ReservationsManagement.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.Reservations;

public class ReservationsDocsDTO {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

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

	public ReservationsDocsDTO(int id, Reservations reservationid, String documentURl) {
		super();
		this.id = id;
		this.reservationid = reservationid;
		this.documentURl = documentURl;
	}

	@Override
	public String toString() {
		return "ReservationsDocsDTO [id=" + id + ", reservationid=" + reservationid + ", documentURl=" + documentURl
				+ "]";
	}

}
