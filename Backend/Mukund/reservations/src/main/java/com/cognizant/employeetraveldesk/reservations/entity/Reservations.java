package com.cognizant.employeetraveldesk.reservations.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservations {

	public Reservations(Integer id, 
			int reservationDoneByEmployeeId, 
			int travelRequestId,
			ReservationTypes reservationTypes, 
			LocalDate createdOn, 
			String reservationDoneWithEntity,
			LocalDate reservationDate, 
			int amount, 
			String confirmationId, 
			String remarks) {
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

	public Reservations() {
		
	}
	
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

	@Column(name="createdon")
	private LocalDate createdOn;
	
	@Column(name="reservationdonewithentity")
	private String reservationDoneWithEntity;
	
	@Column(name="reservationdate")
	private LocalDate ReservationDate;

	@Column(name="amount")
	private int amount;
	
	@Column(name="confirmationid")
	private String confirmationId;
	
	@Column(name="remarks")
	private String remarks;
	
	@OneToMany(mappedBy="reservationid")
	private List<ReservationDocs> reservationDocs;
	
	@PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }

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
	 * @return the reservationTypes
	 */
	public ReservationTypes getReservationTypes() {
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
	 * @param reservationTypes the reservationTypes to set
	 */
	public void setReservationTypes(ReservationTypes reservationTypes) {
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
				+ ", travelRequestId=" + travelRequestId + ", reservationTypes=" + reservationTypes + ", createdOn="
				+ createdOn + ", reservationDoneWithEntity=" + reservationDoneWithEntity + ", ReservationDate="
				+ ReservationDate + ", amount=" + amount + ", confirmationId=" + confirmationId + ", remarks=" + remarks
				+ "]";
	}
	
}
