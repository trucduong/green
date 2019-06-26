package com.green.example.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.web.multipart.MultipartFile;

import com.green.example.entity.Contact;

import utils.Gender;

public class ContactModel {
	private long id;
	
	private String avatar;
	
	private MultipartFile avatarFile;
	
	private Gender gender;
	
	private String name;
	
	private String birthDate;
	
	private String address;
	
	private String note;
	
	public void toContact(Contact contact) {
		contact.setId(this.getId());
		contact.setAddress(this.getAddress());
		contact.setAvatar(this.getAvatar());
		contact.setName(this.getName());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			contact.setBirthDate(dateFormat.parse(this.getBirthDate()));
		} catch (ParseException e) {
			contact.setBirthDate(null);
		}
		contact.setGender(this.getGender());
		contact.setNote(this.getNote());
	}
	
	public void fromContact(Contact contact) {
		this.setId(contact.getId());
		this.setAddress(contact.getAddress());
		this.setAvatar(contact.getAvatar());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.setBirthDate(dateFormat.format(contact.getBirthDate()));
		this.setGender(contact.getGender());
		this.setName(contact.getName());
		this.setNote(contact.getNote());
		this.setAvatar(contact.getAvatar());
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

	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
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
	
	public MultipartFile getAvatarFile() {
		return avatarFile;
	}
	
	public void setAvatarFile(MultipartFile avatarFile) {
		this.avatarFile = avatarFile;
	}

}
