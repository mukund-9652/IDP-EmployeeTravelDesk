package com.cognizant.employeetraveldesk.humanresources.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class GradesHistoryDTO {
	public GradesHistoryDTO() {
		//Empty Constructor
	}
	public GradesHistoryDTO(Integer id, LocalDate assignedOn, UsersDTO usersDTO, GradesDTO gradesDTO) {
		super();
		this.id = id;
		this.assignedOn = assignedOn;
		this.usersDTO = usersDTO;
		this.gradesDTO = gradesDTO;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="assignedon")
	private LocalDate assignedOn;
	
	private UsersDTO usersDTO;
	
	private GradesDTO gradesDTO;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the assignedOn
	 */
	public LocalDate getAssignedOn() {
		return assignedOn;
	}

	/**
	 * @return the usersDTO
	 */
	public UsersDTO getUsers() {
		return usersDTO;
	}

	/**
	 * @return the gradesDTO
	 */
	public GradesDTO getGrades() {
		return gradesDTO;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param assignedOn the assignedOn to set
	 */
	public void setAssignedOn(LocalDate assignedOn) {
		this.assignedOn = assignedOn;
	}

	/**
	 * @param usersDTO the usersDTO to set
	 */
	public void setUsers(UsersDTO usersDTO) {
		this.usersDTO = usersDTO;
	}

	/**
	 * @param gradesDTO the gradesDTO to set
	 */
	public void setGrades(GradesDTO gradesDTO) {
		this.gradesDTO = gradesDTO;
	}

	@Override
	public String toString() {
		return "GradesHistoryDTO [id=" + id + ", assignedOn=" + assignedOn + ", usersDTO=" + usersDTO + ", gradesDTO=" + gradesDTO
				+ "]";
	}
	
	
}
