package com.green.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.green.example.dao.ContactDao;
import com.green.example.entity.Contact;

public class ContactService {
	
	@Autowired
	private ContactDao contactDao;
	
//	@Autowired
//	private EmailContactDao emailContactDao;
	
//	@Autowired
//	private PhoneContactDao phoneContactDao;

	public List<Contact> findAll() {
		return contactDao.findAll();
	}

	public Contact createContact(Contact contact) {
		Contact result = contactDao.create(contact);
		return result;
	}
	
	public Contact findContact(long id) {
		return contactDao.find(id);
	}
	
	public void deleteContact(long contactId) {
		// delete email contact
		
		// delete phone contact
		
		// delete contact
	}
}
