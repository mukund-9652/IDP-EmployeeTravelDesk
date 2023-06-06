package com.cognizant.employeetraveldesk.reservations.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservationdocs")
public class ReservationDocs {
	/**
	 * @param id
	 * @param reservation
	 * @param documentURL
	 */
	public ReservationDocs(Integer id, Reservations reservation, String documentURL) {
		super();
		this.id = id;
		this.reservationid = reservation;
		this.documentURL = documentURL;
	}
	
	public ReservationDocs() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="reservationid")
	private Reservations reservationid;
	
	@Column(name="documenturl")
	private String documentURL;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the reservation
	 */
	public Reservations getReservation() {
		return reservationid;
	}
	/**
	 * @return the documentURL
	 */
	public String getDocumentURL() {
		return documentURL;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param reservation the reservation to set
	 */
	public void setReservation(Reservations reservation) {
		this.reservationid = reservation;
	}
	/**
	 * @param documentURL the documentURL to set
	 */
	public void setDocumentURL(String documentURL) {
		this.documentURL = documentURL;
	}
	@Override
	public String toString() {
		return "ReservationDocs [id=" + id + ", reservation=" + reservationid + ", documentURL=" + documentURL + "]";
	}
	
	
}
