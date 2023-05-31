package com.cognizant.employeetraveldesk.reservations.model;

import java.time.LocalDate;

public class ReservationsDTO {

	/**
	 * @param id
	 * @param reservationDoneByEmployeeId
	 * @param travelRequestId
	 * @param reservationTypesDTO
	 * @param createdOn
	 * @param reservationDoneWithEntity
	 * @param reservationDate
	 * @param amount
	 * @param confirmationId
	 * @param remarks
	 */
	public ReservationsDTO(Integer id, int reservationDoneByEmployeeId, int travelRequestId,
			ReservationTypesDTO reservationTypesDTO, LocalDate createdOn, String reservationDoneWithEntity,
			LocalDate reservationDate, int amount, String confirmationId, String remarks) {
		super();
		this.id = id;
		this.reservationDoneByEmployeeId = reservationDoneByEmployeeId;
		this.travelRequestId = travelRequestId;
		this.reservationTypesDTO = reservationTypesDTO;
		this.createdOn = createdOn;
		this.reservationDoneWithEntity = reservationDoneWithEntity;
		ReservationDate = reservationDate;
		this.amount = amount;
		this.confirmationId = confirmationId;
		this.remarks = remarks;
	}

	private Integer id;
	private int reservationDoneByEmployeeId;
	private int travelRequestId;
	private ReservationTypesDTO reservationTypesDTO;
	private LocalDate createdOn;
	private String reservationDoneWithEntity;
	private LocalDate ReservationDate;
	private int amount;
	private String confirmationId;
	private String remarks;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the reservationDoneByEmployeeId
	 */
	public int getReservationDoneByEmployeeId() {
		return reservationDoneByEmployeeId;
	}

	/**
	 * @return the travelRequestId
	 */
	public int getTravelRequestId() {
		return travelRequestId;
	}

	/**
	 * @return the reservationTypesDTO
	 */
	public ReservationTypesDTO getReservationTypesDTO() {
		return reservationTypesDTO;
	}

	/**
	 * @return the createdOn
	 */
	public LocalDate getCreatedOn() {
		return createdOn;
	}

	/**
	 * @return the reservationDoneWithEntity
	 */
	public String getReservationDoneWithEntity() {
		return reservationDoneWithEntity;
	}

	/**
	 * @return the reservationDate
	 */
	public LocalDate getReservationDate() {
		return ReservationDate;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @return the confirmationId
	 */
	public String getConfirmationId() {
		return confirmationId;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param reservationDoneByEmployeeId the reservationDoneByEmployeeId to set
	 */
	public void setReservationDoneByEmployeeId(int reservationDoneByEmployeeId) {
		this.reservationDoneByEmployeeId = reservationDoneByEmployeeId;
	}

	/**
	 * @param travelRequestId the travelRequestId to set
	 */
	public void setTravelRequestId(int travelRequestId) {
		this.travelRequestId = travelRequestId;
	}

	/**
	 * @param reservationTypesDTO the reservationTypesDTO to set
	 */
	public void setReservationTypesDTO(ReservationTypesDTO reservationTypesDTO) {
		this.reservationTypesDTO = reservationTypesDTO;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @param reservationDoneWithEntity the reservationDoneWithEntity to set
	 */
	public void setReservationDoneWithEntity(String reservationDoneWithEntity) {
		this.reservationDoneWithEntity = reservationDoneWithEntity;
	}

	/**
	 * @param reservationDate the reservationDate to set
	 */
	public void setReservationDate(LocalDate reservationDate) {
		ReservationDate = reservationDate;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @param confirmationId the confirmationId to set
	 */
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ReservationsDTO [id=" + id + ", reservationDoneByEmployeeId=" + reservationDoneByEmployeeId
				+ ", travelRequestId=" + travelRequestId + ", reservationTypesDTO=" + reservationTypesDTO
				+ ", createdOn=" + createdOn + ", reservationDoneWithEntity=" + reservationDoneWithEntity
				+ ", ReservationDate=" + ReservationDate + ", amount=" + amount + ", confirmationId=" + confirmationId
				+ ", remarks=" + remarks + "]";
	}

}
