package com.cognizant.employeetraveldesk.reservations.entity;

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

	/**
	 * @param typeId
	 * @param typeName
	 */
	public ReservationTypes(Integer typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;

	}
	public ReservationTypes() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "typeid")
	private Integer typeId;

	@Column(name = "typename")
	private String typeName;

	@OneToMany(mappedBy = "reservationTypes")
	private List<Reservations> reservations;

	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "ReservationTypes [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
