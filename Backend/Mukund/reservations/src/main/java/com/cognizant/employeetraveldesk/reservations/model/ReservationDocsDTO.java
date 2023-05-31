package com.cognizant.employeetraveldesk.reservations.model;

public class ReservationDocsDTO {
	/**
	 * @param id
	 * @param reservation
	 * @param documentURL
	 */
	public ReservationDocsDTO(Integer id, ReservationsDTO reservation, String documentURL) {
		super();
		this.id = id;
		this.reservation = reservation;
		this.documentURL = documentURL;
	}

	private Integer id;
	private ReservationsDTO reservation;
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
	public ReservationsDTO getReservation() {
		return reservation;
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
	public void setReservation(ReservationsDTO reservation) {
		this.reservation = reservation;
	}

	/**
	 * @param documentURL the documentURL to set
	 */
	public void setDocumentURL(String documentURL) {
		this.documentURL = documentURL;
	}

	@Override
	public String toString() {
		return "ReservationDocsDTO [id=" + id + ", reservation=" + reservation + ", documentURL=" + documentURL + "]";
	}
}
