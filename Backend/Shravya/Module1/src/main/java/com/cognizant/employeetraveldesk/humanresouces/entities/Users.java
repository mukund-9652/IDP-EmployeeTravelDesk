package com.cognizant.employeetraveldesk.humanresouces.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column(name="employeeid")
	private long EmployeeId;
	@Column(name="firstname")
	private String FirstName;
	@Column(name="lastname")
	private String LastName;
	@Column(name="phonenumber")
	private String PhoneNumber;
	@Column(name="emailaddress")
	private String EmailAddress;
	@Column(name="roles")
	private String Roles;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "currentgradeid")
	private Grades CurrentGradeId;
	@Column(name="accessgranted")
	private boolean AccessGranted;

	public long getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(long employeeId) {
		EmployeeId = employeeId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getRoles() {
		return Roles;
	}

	public void setRoles(String roles) {
		Roles = roles;
	}

	

	@Override
	public String toString() {
		return "Users [EmployeeId=" + EmployeeId + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", PhoneNumber=" + PhoneNumber + ", EmailAddress=" + EmailAddress + ", Roles=" + Roles
				+ ", CurrentGradeId=" + getCurrentGradeId() + ", AccessGranted=" + getAccessGranted() + "]";
	}

	public Grades getCurrentGradeId() {
		return CurrentGradeId;
	}

	public void setCurrentGradeId(Grades currentGradeId) {
		CurrentGradeId = currentGradeId;
	}

	public boolean getAccessGranted() {
		return AccessGranted;
	}

	public void setAccessGranted(boolean accessGranted) {
		AccessGranted = accessGranted;
	}

}
