package com.cognizant.employeetraveldesk.reimbursement.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Reimbursementtypes")
public class ReimbursementTypes {

	@Id
	@Column(name = "id", length = 10)
	private int id;

	@Column(name = "type", length = 25)
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(mappedBy = "reimbursementTypes")
	private List<ReimbursementRequests> requests;

	ReimbursementTypes() {
		super();
	}

	public ReimbursementTypes(int id, String type) {
		this.id = id;
		this.type = type;
	}

}
