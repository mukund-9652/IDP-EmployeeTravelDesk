package com.cognizant.employeetraveldesk.humanresouces.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grades")
public class Grades {
	@Id
	@Column(name = "Id")
	private int Id;
	@Column(name = "name")
	private String name;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Grades [Id=" + Id + ", name=" + name + "]";
	}

}
