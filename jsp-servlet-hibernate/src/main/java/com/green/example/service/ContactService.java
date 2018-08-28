package com.green.example.service;

import java.util.List;

import com.green.example.dao.ContactDao;
import com.green.example.entity.Contact;

public class ContactService {
	private ContactDao contactDao;
//	private EmailContactDao emailContactDao;
//	private PhoneContactDao phoneContactDao;

	public ContactService() {
		contactDao = new ContactDao();
//		emailContactDao = new EmailContactDao();
//		phoneContactDao = new PhoneContactDao();
	}

	public List<Contact> search(String name) {
		if (name == null || name.length() == 0) {
			return contactDao.findAll();
		}

		return contactDao.findByName(name);
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
