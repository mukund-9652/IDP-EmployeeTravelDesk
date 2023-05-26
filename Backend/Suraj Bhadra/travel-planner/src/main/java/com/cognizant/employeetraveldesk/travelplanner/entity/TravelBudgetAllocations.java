package com.cognizant.employeetraveldesk.travelplanner.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="travelbudgetallocations")
public class TravelBudgetAllocations {

	//setting a primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	//performing one to one mapping with travel requests table
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
	
	
	public TravelBudgetAllocations(int id, TravelRequests travelRequests, int approvedBudget,
			String approvedModeOfTravel, String approvedHotelStarRating) {
		super();
		this.id = id;
		this.travelRequests = travelRequests;
		this.approvedBudget = approvedBudget;
		this.approvedModeOfTravel = approvedModeOfTravel;
		this.approvedHotelStarRating = approvedHotelStarRating;
	}

	public TravelBudgetAllocations() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
