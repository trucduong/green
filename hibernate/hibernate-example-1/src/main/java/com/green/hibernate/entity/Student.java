package com.green.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private long id;

	@Column(name = "student_name")
	private String name;

	@OneToOne
	@JoinColumn(name = "student_address")
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	@Override
	public String toString() {
		return "{"
				+ " id: " + id
				+ ", name: " + name
				+ ", address: " + address.toString()
				+ " }";
	}
	
}
