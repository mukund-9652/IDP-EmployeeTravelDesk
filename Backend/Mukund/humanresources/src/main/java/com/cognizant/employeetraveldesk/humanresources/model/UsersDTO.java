package com.cognizant.employeetraveldesk.humanresources.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UsersDTO {

	public UsersDTO() {
		// Empty Constructors
	}

	public UsersDTO(Integer employeeid, String firstName, String lastName, String phoneNumber, String emailAddress,
			String role, GradesDTO gradesDTO) {
		super();
		this.employeeid = employeeid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.role = role;
		this.gradesDTO = gradesDTO;
	}

	@Id
	@Column(name="employeeid")
	private Integer employeeid;

	@Column(name = "firstname", length = 15)
	@Size(min = 3, message = "First Name Must Be More Than 3 Characters")
	@Size(max = 15, message = "First Name Must Be Less Than 15 Characters")
	private String firstName;

	@Column(name = "lastname", length = 10)
	@Size(min = 3, message = "Last Name Must Be More Than 3 Characters")
	@Size(max = 10, message = "Last Name Must Be Less Than 10 Characters")
	private String lastName;

	@Column(name = "phonenumber", length = 10)
	@Size(min = 10, message = "Phone Number Must Exactly have 10 Numbers")
	@Size(max = 10, message = "Phone Number Must Exactly have 10 Numbers")
	@Pattern(regexp = "^[0-9]+$", message = "Phone number should contain only digits")
	private String phoneNumber;

	@Column(name = "emailaddress", length = 50)
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email address format")
	private String emailAddress;

	@Pattern(regexp = "Employee|HR|TravelDeskExe", message = "Invalid Role. Role should exactly be Employee | HR | TravelDeskExe")
	@Column(name = "role", length = 15)
	private String role;

	private GradesDTO gradesDTO;

	/**
	 * @return the employeeid
	 */
	public Integer getEmployeeid() {
		return employeeid;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the gradesDTO
	 */
	public GradesDTO getGrades() {
		return gradesDTO;
	}

	/**
	 * @param employeeid the employeeid to set
	 */
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @param gradesDTO the gradesDTO to set
	 */
	public void setGrades(GradesDTO gradesDTO) {
		this.gradesDTO = gradesDTO;
	}

	@Override
	public String toString() {
		return "UsersDTO [employeeid=" + employeeid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", role=" + role + ", gradesDTO="
				+ gradesDTO + "]";
	}

}
