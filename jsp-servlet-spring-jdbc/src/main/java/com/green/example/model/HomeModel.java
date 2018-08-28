package com.green.example.model;

import java.util.ArrayList;
import java.util.List;

import com.green.example.entity.Contact;

/**
 * Model class for Home page
 *
 */
public class HomeModel {
	private List<Contact> contacts = new ArrayList<>();
	
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public boolean isEmpty() {
		return contacts == null || contacts.size() == 0;
	}
}
