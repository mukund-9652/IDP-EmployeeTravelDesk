package com.cognizant.employeetraveldesk.travelplanner.model;

import java.time.LocalDate;

import com.cognizant.employeetraveldesk.travelplanner.entity.Locations;
import com.cognizant.employeetraveldesk.travelplanner.entity.TravelBudgetAllocations;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class TravelRequestsDTO {

	
	@Id
	@Column(name = "requestid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestId;
	@Column(name = "raisedbyemployeeid")
	private int raisedByEmployeeId;
	@Column(name = "tobeapprovedbyhrid")
	private int toBeApprovedByHRId;
	@Column(name = "requestraisedon")
	private LocalDate requestRaisedOn;
	@Column(name = "fromdate")
	private LocalDate fromDate;
	@Column(name = "todate")
	private LocalDate toDate;

	@Column(name = "purposeoftravel", length = 100)
	private String purposeOfTravel;

	@ManyToOne
	@JoinColumn(name = "locationid")
	private Locations locations;

	@Column(name = "requeststatus", length = 15)
	private String requestStatus;
	@Column(name = "requestapprovedon")
	private LocalDate requestApprovedOn;
	@Column(name = "priority", length = 6)
	private String priority;

	@OneToOne
	private TravelBudgetAllocations travelBudgetAllocations;

	public int getRequestId() {
		return requestId;
	}

	public int getRaisedByEmployeeId() {
		return raisedByEmployeeId;
	}

	public int getToBeApprovedByHRId() {
		return toBeApprovedByHRId;
	}

	public LocalDate getRequestRaisedOn() {
		return requestRaisedOn;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public String getPurposeOfTravel() {
		return purposeOfTravel;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public LocalDate getRequestApprovedOn() {
		return requestApprovedOn;
	}

	public String getPriority() {
		return priority;
	}

	public TravelBudgetAllocations getTravelBudgetAllocations() {
		return travelBudgetAllocations;
	}

	public Locations getLocations() {
		return locations;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public void setRaisedByEmployeeId(int raisedByEmployeeId) {
		this.raisedByEmployeeId = raisedByEmployeeId;
	}

	public void setToBeApprovedByHRId(int toBeApprovedByHRId) {
		this.toBeApprovedByHRId = toBeApprovedByHRId;
	}

	public void setRequestRaisedOn(LocalDate requestRaisedOn) {
		this.requestRaisedOn = requestRaisedOn;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public void setPurposeOfTravel(String purposeOfTravel) {
		this.purposeOfTravel = purposeOfTravel;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public void setRequestApprovedOn(LocalDate requestApprovedOn) {
		this.requestApprovedOn = requestApprovedOn;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setTravelBudgetAllocations(TravelBudgetAllocations travelBudgetAllocations) {
		this.travelBudgetAllocations = travelBudgetAllocations;
	}

	public void setLocationId(Locations locations) {
		this.locations = locations;
	}

	public TravelRequestsDTO(int requestId, int raisedByEmployeeId, int toBeApprovedByHRId, LocalDate requestRaisedOn,
			LocalDate fromDate, LocalDate toDate, String purposeOfTravel, Locations locations, String requestStatus,
			LocalDate requestApprovedOn, String priority, TravelBudgetAllocations travelBudgetAllocations) {
		super();
		this.requestId = requestId;
		this.raisedByEmployeeId = raisedByEmployeeId;
		this.toBeApprovedByHRId = toBeApprovedByHRId;
		this.requestRaisedOn = requestRaisedOn;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.purposeOfTravel = purposeOfTravel;
		this.locations = locations;
		this.requestStatus = requestStatus;
		this.requestApprovedOn = requestApprovedOn;
		this.priority = priority;
		this.travelBudgetAllocations = travelBudgetAllocations;
	}

}
