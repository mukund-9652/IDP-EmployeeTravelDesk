package com.cognizant.employeetraveldesk.reservations.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reservationtypes")
public class ReservationTypes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="typeid")
	private Integer typeId;
	
	@Column(name="typename")
	private String typeName;
	
	@OneToMany(mappedBy="")
	private List<Reservations> reservations;
}
