package com.cognizant.employeetraveldesk.travelplanner.model;

import com.cognizant.employeetraveldesk.travelplanner.entity.TravelRequests;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class TravelBudgetAllocationsDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	@JoinColumn(name = "travelrequestid")
	private TravelRequests travelRequests;

	@Column(name = "approvedbudget")
	private int approvedBudget;

	@Column(name = "approvedmodeoftravel", length = 10)
	private String approvedModeOfTravel;

	@Column(name = "approvedhotelstarrating", length = 6)
	private String approvedHotelStarRating;

	public int getId() {
		return id;
	}

	public TravelRequests getTravelRequests() {
		return travelRequests;
	}

	public int getApprovedBudget() {
		return approvedBudget;
	}

	public String getApprovedModeOfTravel() {
		return approvedModeOfTravel;
	}

	public String getApprovedHotelStarRating() {
		return approvedHotelStarRating;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTravelRequests(TravelRequests travelRequests) {
		this.travelRequests = travelRequests;
	}

	public void setApprovedBudget(int approvedBudget) {
		this.approvedBudget = approvedBudget;
	}

	public void setApprovedModeOfTravel(String approvedModeOfTravel) {
		this.approvedModeOfTravel = approvedModeOfTravel;
	}

	public void setApprovedHotelStarRating(String approvedHotelStarRating) {
		this.approvedHotelStarRating = approvedHotelStarRating;
	}

	}
