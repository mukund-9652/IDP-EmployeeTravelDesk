package com.cognizant.employeetraveldesk.humanresouces.entities;
import java.time.LocalDate;

import javax.persistence.CascadeType;
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
public class GradeHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long Id;
	@Column(name = "AssignedOn")
	private LocalDate AssignedOn;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="EmployeeId")
	private Users EmployeeId;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="GradeId")
	private Grades GradeId;

	public long getId() {
		return Id;
	}

	public LocalDate getAssignedOn() {
		return AssignedOn;
	}

	public void setAssignedOn(LocalDate assignedOn) {
		AssignedOn = assignedOn;
	}




	public void setId(long id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "GradeHistory [Id=" + Id + ", AssignedOn=" + AssignedOn + ", EmployeeId=" + getEmployeeId() + ", GradeId="
				+ getGradeId() + "]";
	}



	

	public Users getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(Users employeeId) {
		EmployeeId = employeeId;
	}

	public Grades getGradeId() {
		return GradeId;
	}

	public void setGradeId(Grades gradeId) {
		GradeId = gradeId;
	}



}
