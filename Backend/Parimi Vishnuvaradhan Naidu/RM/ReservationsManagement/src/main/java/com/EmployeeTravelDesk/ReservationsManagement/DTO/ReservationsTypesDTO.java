package com.EmployeeTravelDesk.ReservationsManagement.DTO;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.Reservations;

public class ReservationsTypesDTO {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeId;

	private String typeName;

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


	public ReservationsTypesDTO(int typeId, String typeName, List<Reservations> reservationList) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "ReservationsTypesDTO [typeId=" + typeId + ", typeName=" + typeName + ", reservationList="
				+ "]";
	}

}
