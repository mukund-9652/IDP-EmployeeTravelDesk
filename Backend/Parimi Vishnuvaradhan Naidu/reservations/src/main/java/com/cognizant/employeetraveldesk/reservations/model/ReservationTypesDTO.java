package com.cognizant.employeetraveldesk.reservations.model;

public class ReservationTypesDTO {

	/**
	 * @param typeId
	 * @param typeName
	 * @param reservationsDTO
	 */
	public ReservationTypesDTO(Integer typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	private Integer typeId;
	private String typeName;

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
		return "ReservationTypesDTO [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
