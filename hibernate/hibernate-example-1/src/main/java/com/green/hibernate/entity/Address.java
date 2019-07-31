package com.green.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue
	@Column(name="address_id")
	private long id;
	
	@Column(name="address_street")
	private String street;
	
	@Column(name="address_city")
	private String city;
	
	@Column(name="address_state")
	private String state;
	
	@Column(name="address_zipcode")
	private String zipcode;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	@Override
	public String toString() {
		return "{"
				+ " id: " + id
				+ ", street: " + street
				+ ", city: " + city
				+ ", state: " + state
				+ ", zipcode: " + zipcode
				+ " }";
	}
	
}
