package com.cognizant.employeetraveldesk.travelplanner.model;

import java.util.List;

import com.cognizant.employeetraveldesk.travelplanner.entity.TravelRequests;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class LocationsDTO {
	public LocationsDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", length = 20)
	private String name;
	
	@OneToMany(mappedBy="locations")
	private List<TravelRequests> travelRequests;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocationsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
