package com.cognizant.employeetraveldesk.humanresources.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class GradesDTO {

	public GradesDTO() {
		// Empty Constructor
	}

	public GradesDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	private Integer id;

	@Column(name = "name", length = 25)
	@Size(min = 3, message = "Name Must Be More Than 3 Characters")
	@Size(max = 10, message = "Name Must Be Less Than 25 Characters")
	private String name;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GradesDTO [id=" + id + ", name=" + name + "]";
	}

}
