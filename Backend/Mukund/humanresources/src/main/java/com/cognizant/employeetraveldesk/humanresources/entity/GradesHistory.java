package com.cognizant.employeetraveldesk.humanresources.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="gradeshistory")
public class GradesHistory {
	public GradesHistory() {
		//Empty Constructor
	}
	public GradesHistory(Integer id, LocalDate assignedOn, Users employeeid, Grades grades) {
		super();
		this.id = id;
		this.assignedOn = assignedOn;
		this.employeeid = employeeid;
		this.grades = grades;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="assignedon")
	private LocalDate assignedOn;
	
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Users employeeid;
	
	@ManyToOne
	@JoinColumn(name="gradeid")
	private Grades grades;

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
	 * @return the users
	 */
	public Users getEmployeeid() {
		return employeeid;
	}

	/**
	 * @return the grades
	 */
	public Grades getGrades() {
		return grades;
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
	 * @param users the users to set
	 */
	public void setEmployeeid(Users employeeid) {
		this.employeeid = employeeid;
	}

	/**
	 * @param grades the grades to set
	 */
	public void setGrades(Grades grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "GradesHistoryDTO [id=" + id + ", assignedOn=" + assignedOn + ", employeeid=" + employeeid + ", grades=" + grades
				+ "]";
	}
	
	
}
