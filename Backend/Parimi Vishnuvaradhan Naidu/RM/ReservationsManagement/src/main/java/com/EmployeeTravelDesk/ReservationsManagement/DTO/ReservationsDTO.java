package com.EmployeeTravelDesk.ReservationsManagement.DTO;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

//import antlr.collections.List;

import javax.validation.constraints.NotNull;
//import javax.persistence.ManytoOne;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.CreatedDate;

//import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationDocs;
import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationTypes;

@Entity
@Table(name = "Reservations")
public class ReservationsDTO {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private long reservationsDoneByEmployeeId;

	private long travelRequestId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getReservationsDoneByEmployeeId() {
		return reservationsDoneByEmployeeId;
	}

	public void setReservationsDoneByEmployeeId(long reservationsDoneByEmployeeId) {
		this.reservationsDoneByEmployeeId = reservationsDoneByEmployeeId;
	}

	public long getTravelRequestId() {
		return travelRequestId;
	}

	public void setTravelRequestId(long travelRequestId) {
		this.travelRequestId = travelRequestId;
	}

	public ReservationTypes getReservationTypeId() {
		return reservationTypeId;
	}

	public void setReservationTypeId(ReservationTypes reservationTypeId) {
		this.reservationTypeId = reservationTypeId;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getReservationDoneWithEntity() {
		return reservationDoneWithEntity;
	}

	public void setReservationDoneWithEntity(String reservationDoneWithEntity) {
		this.reservationDoneWithEntity = reservationDoneWithEntity;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getConfirmationID() {
		return confirmationID;
	}

	public void setConfirmationID(String confirmationID) {
		this.confirmationID = confirmationID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	private ReservationTypes reservationTypeId;

	@CreatedDate

	private LocalDate createdOn;

	private String reservationDoneWithEntity;

	@CreatedDate

	private LocalDate reservationDate;
	@Positive(message = "amount must be positive only")
	@NotNull(message = "Amount must be not null")

	private long amount;
	private String confirmationID;
	private String remarks;

	public ReservationsDTO(int id, long reservationsDoneByEmployeeId, long travelRequestId,
			ReservationTypes reservationTypeId, LocalDate createdOn, String reservationDoneWithEntity,
			LocalDate reservationDate,
			@Positive(message = "amount must be positive only") @NotNull(message = "Amount must be not null") long amount,
			String confirmationID, String remarks) {
		super();
		this.id = id;
		this.reservationsDoneByEmployeeId = reservationsDoneByEmployeeId;
		this.travelRequestId = travelRequestId;
		this.reservationTypeId = reservationTypeId;
		this.createdOn = createdOn;
		this.reservationDoneWithEntity = reservationDoneWithEntity;
		this.reservationDate = reservationDate;
		this.amount = amount;
		this.confirmationID = confirmationID;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ReservationsDTO [id=" + id + ", reservationsDoneByEmployeeId=" + reservationsDoneByEmployeeId
				+ ", travelRequestId=" + travelRequestId + ", reservationTypeId=" + reservationTypeId + ", createdOn="
				+ createdOn + ", reservationDoneWithEntity=" + reservationDoneWithEntity + ", reservationDate="
				+ reservationDate + ", amount=" + amount + ", confirmationID=" + confirmationID + ", remarks=" + remarks
				+ "]";
	}

}
