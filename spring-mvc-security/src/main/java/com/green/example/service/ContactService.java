package com.green.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.example.dao.ContactDao;
import com.green.example.entity.Contact;

@Service
public class ContactService {
	
	@Autowired
	private ContactDao contactDao;
	
//	@Autowired
//	private EmailContactDao emailContactDao;
	
//	@Autowired
//	private PhoneContactDao phoneContactDao;

	public List<Contact> search(String name) {
		if (name == null || name.length() == 0) {
			return contactDao.findAll();
		}

		return contactDao.findByName(name);
	}

	@Transactional
	public Contact createContact(Contact contact) {
		Contact result = contactDao.create(contact);
		return result;
	}
	
	public Contact findContact(long id) {
		return contactDao.find(id);
	}
	
	@Transactional
	public void deleteContact(long contactId) {
		// delete email contact
		
		// delete phone contact
		
		// delete contact
	}
}
