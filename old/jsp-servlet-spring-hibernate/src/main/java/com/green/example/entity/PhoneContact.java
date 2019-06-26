package com.green.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone_contacts")
public class PhoneContact {
	@Id
	@Column(name = "phone")
	private String phone;

//	private long contactId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private Contact contact;


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
