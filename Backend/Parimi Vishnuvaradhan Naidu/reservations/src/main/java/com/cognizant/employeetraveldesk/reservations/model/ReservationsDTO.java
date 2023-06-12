package com.cognizant.employeetraveldesk.reservations.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
			ReservationTypesDTO reservationTypes, LocalDate createdOn, String reservationDoneWithEntity,
			LocalDate reservationDate, int amount, String confirmationId, String remarks) {
		super();
		this.id = id;
		this.reservationDoneByEmployeeId = reservationDoneByEmployeeId;
		this.travelRequestId = travelRequestId;
		this.reservationTypes = reservationTypes;
		this.createdOn = createdOn;
		this.reservationDoneWithEntity = reservationDoneWithEntity;
		ReservationDate = reservationDate;
		this.amount = amount;
		this.confirmationId = confirmationId;
		this.remarks = remarks;
	}

	private Integer id;
	
	@Min(value = 1, message = "Employee Id must be at least 1")
	private int reservationDoneByEmployeeId;

	@Min(value = 1, message = "Travel Request Id must be at least 1")
	private int travelRequestId;
	
	private ReservationTypesDTO reservationTypes;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createdOn;
	
	@NotBlank(message = "Reservation Done With Entity cannot be null/empty")
	@Size(min = 5, message = "Reservation Done With Entity must have more than 5 symbols")
	private String reservationDoneWithEntity;
	
	private LocalDate ReservationDate;
	
	@Min(value = 100, message = "Amount must be at least Rs.100")
	private int amount;
	
	@Size(min = 5, message = "Confirmation Id must have more than 5 symbols")
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
	public ReservationTypesDTO getReservationTypes() {
		return reservationTypes;
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
	public void setReservationTypesDTO(ReservationTypesDTO reservationTypes) {
		this.reservationTypes = reservationTypes;
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
				+ ", travelRequestId=" + travelRequestId + ", reservationTypes=" + reservationTypes
				+ ", createdOn=" + createdOn + ", reservationDoneWithEntity=" + reservationDoneWithEntity
				+ ", ReservationDate=" + ReservationDate + ", amount=" + amount + ", confirmationId=" + confirmationId
				+ ", remarks=" + remarks + "]";
	}

}
