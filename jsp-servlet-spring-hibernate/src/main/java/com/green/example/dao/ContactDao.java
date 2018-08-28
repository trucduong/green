package com.green.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.green.example.entity.Contact;

public class ContactDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	public List<Contact> findAll() {
		Session session = sessionFactory.openSession();
		String queryStr = "FROM Contact";
		TypedQuery<Contact> query = session.createQuery(queryStr, Contact.class);
		List<Contact> contacts = query.getResultList();
		return contacts;
	}

	public Contact find(long id) {
		return null;
	}

	public List<Contact> findByName(String name) {
		return new ArrayList<>();
	}

	public Contact create(Contact contact) {
		return null;
	}

	public Contact update(Contact contact) {
		return contact;
	}

	public void delete(long id) {

	}

}
