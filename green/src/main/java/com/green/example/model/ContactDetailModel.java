package com.green.example.model;

import java.util.Date;

import com.green.example.entity.Contact;

import utils.Gender;

public class ContactDetailModel {
	
	private boolean errContactNotFound = false;
	
	/**
	 * contact info
	 */
	private long id = 0;
	private String avatar;
	private Gender gender;
	private String name;
	private Date birthDate;
	private String address;
	private String note;
	
	public void setContact(Contact contact) {
		this.id = contact.getId();
		this.avatar = contact.getAvatar();
		this.gender = contact.getGender();
		this.name = contact.getName();
		this.birthDate = contact.getBirthDate();
		this.address = contact.getAddress();
		this.note = contact.getNote();
	}
	
	public Contact getContact() {
		Contact contact = new Contact();
		contact.setId(this.id);
//		contact.setAvatar(this.avatar); // replace with multipart file
		contact.setGender(this.gender);
		contact.setName(this.name);
		contact.setBirthDate(this.birthDate);
		contact.setAddress(this.address);
		contact.setNote(this.note);
		
		return contact;
	}
	
	public boolean isUpdating() {
		return this.id != 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public boolean isErrContactNotFound() {
		return errContactNotFound;
	}
	
	public void setErrContactNotFound(boolean errContactNotFound) {
		this.errContactNotFound = errContactNotFound;
	}
}
