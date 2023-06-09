package com.EmployeeTravelDesk.ReservationsManagement.Entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reservationtypes")
public class ReservationTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="typeid")
	private int typeId;
	
	@Column(name="typename")
	private String typeName;
	
	@OneToMany(mappedBy = "reservationTypes",cascade = CascadeType.ALL)
	private List<Reservations> reservationList;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Reservations> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservations> reservationList) {
		this.reservationList = reservationList;
	}

	@Override
	public String toString() {
		return "ReservationTypes [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

	public ReservationTypes(int typeId, String typeName, List<Reservations> reservationList) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.reservationList = reservationList;
	}
	public ReservationTypes() {
		
	}
	

}
