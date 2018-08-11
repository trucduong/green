package com.green.example.service;

import java.util.ArrayList;
import java.util.List;

import com.green.example.dao.ContactDao;
import com.green.example.dao.EmailContactDao;
import com.green.example.dao.PhoneContactDao;
import com.green.example.entity.Contact;
import com.green.example.entity.EmailContact;
import com.green.example.entity.PhoneContact;

public class ContactService {
	private ContactDao contactDao;
	private EmailContactDao emailContactDao;
	private PhoneContactDao phoneContactDao;

	public ContactService() {
		contactDao = new ContactDao();
		emailContactDao = new EmailContactDao();
		phoneContactDao = new PhoneContactDao();
	}

	public List<Contact> search(String name) {
		if (name == null || name.length() == 0) {
			return contactDao.findAll();
		}

		return contactDao.findByName(name);
	}

	public Contact createContact(Contact contact) {
		return createContact(contact, null, null);
	}
	
	public Contact createContact(Contact contact, List<String> emails, List<String> phones) {
		// Create contact
		Contact result = contactDao.create(contact);
		long contactId = result.getId();
		
		// create Email contact list
		createEmailContacts(contactId, emails);
		
		// Create Phone contact list
		createPhoneContacts(contactId, phones);
		
		return null;
	}
	
	public List<EmailContact> createEmailContacts(long contactId, List<String> emails) {
		List<EmailContact> results = new ArrayList<>();
		if (emails != null && emails.size() > 0) {
			for (String email : emails) {
				EmailContact emailContact = new EmailContact();
				emailContact.setContactId(contactId);
				emailContact.setEmail(email);
				
				EmailContact result = emailContactDao.create(emailContact);
				results.add(result);
			}
		}
		
		return results;
	}
	
	public List<PhoneContact> createPhoneContacts(long contactId, List<String> phones) {
		List<PhoneContact> results = new ArrayList<>();
		if (phones != null && phones.size() > 0) {
			for (String phone : phones) {
				PhoneContact phoneContact = new PhoneContact();
				phoneContact.setContactId(contactId);
				phoneContact.setPhone(phone);
				
				PhoneContact result = phoneContactDao.create(phoneContact);
				results.add(result);
			}
		}
		
		return results;
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
