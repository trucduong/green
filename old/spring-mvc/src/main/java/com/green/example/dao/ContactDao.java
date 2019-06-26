package com.green.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.example.entity.Contact;

@Repository
public class ContactDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Contact> findAll() {
		Session session = getSession();
		String queryStr = "FROM Contact";
		TypedQuery<Contact> query = session.createQuery(queryStr, Contact.class);
		List<Contact> contacts = query.getResultList();
		
		return contacts;
	}

	public Contact find(long id) {
		Session session = getSession();
		Contact contact = session.find(Contact.class, id);
		
		return contact;
	}

	public List<Contact> findByName(String name) {
		return new ArrayList<>();
	}

	public Contact create(Contact contact) {
		Session session = getSession();
		Long id = (Long) session.save(contact);
		contact.setId(id);
		
		return contact;
	}

	public Contact update(Contact contact) {
		Session session = getSession();
		session.saveOrUpdate(contact);
		
		return contact;
	}

	public void delete(long id) {

	}

}
