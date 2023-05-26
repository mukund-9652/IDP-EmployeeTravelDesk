package EmployeeTravelDesk.ReservationsManagement.Entities;

import java.time.LocalDate;
//import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.ManytoOne;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.CreatedDate;

//import antlr.collections.List;

import javax.validation.constraints.NotNull;
@Entity
@Table(name="Reservations")
public class Reservations {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="reservationsDoneByEmployeeId")
	private long reservationsDoneByEmployeeId;

	private long travelRequestId;
	 
	@ManyToOne
	@JoinColumn(name="reservationTypeId")
	private ReservationTypes reservationTypeId;
	
	
	
	@CreatedDate
	@Column(columnDefinition ="Date default(curdate())" )
	private LocalDate createdOn;
	
	private String reservationDoneWithEntity;
	
	@CreatedDate
	@Column(columnDefinition = "Date default(curdate())")
	private LocalDate reservationDate;
	
	@Override
	public String toString() {
		return "Reservations [reservationsDoneByEmployeeId=" + reservationsDoneByEmployeeId + ", travelRequestId="
				+ travelRequestId + ", reservationTypeId=" + reservationTypeId + ", createdOn=" + createdOn
				+ ", reservationDoneWithEntity=" + reservationDoneWithEntity + ", reservationDate=" + reservationDate
				+ ", amount=" + amount + ", confirmationID=" + confirmationID + ", remarks=" + remarks + "]";
	}
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
	public List<ReservationDocs> getReservationDocsList() {
		return reservationDocsList;
	}
	public void setReservationDocsList(List<ReservationDocs> reservationDocsList) {
		this.reservationDocsList = reservationDocsList;
	}
	@Positive (message = "amount must be positive only")
	@NotNull(message = "Amount must be not null")
	@Column(name="Amount")
	private long amount;
	private String confirmationID;
	private String remarks;
	@OneToMany(mappedBy = "reservationid",cascade = CascadeType.ALL)
	private List<ReservationDocs> reservationDocsList;

	public Reservations(long reservationsDoneByEmployeeId, long travelRequestId, ReservationTypes reservationTypeId,
			LocalDate createdOn, String reservationDoneWithEntity, LocalDate reservationDate,
			@Positive(message = "amount must be positive only") @NotNull(message = "Amount must be not null") long amount,
			String confirmationID, String remarks) {
		super();
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
	public Reservations()
	{
	}
}
	
	
	