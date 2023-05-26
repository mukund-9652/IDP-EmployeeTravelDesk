package com.cognizant.employeetraveldesk.travelplanner.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="locations")
public class Locations {
	public Locations(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	//setting primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", length = 20)
	private String name;
	
	//performing one to many mapping with travel requests table
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

	
	public Locations(int id, String name, List<TravelRequests> travelRequests) {
		super();
		this.id = id;
		this.name = name;
		this.travelRequests = travelRequests;
	}

	public Locations() {
		super();
		// TODO Auto-generated constructor stub
	}
}
