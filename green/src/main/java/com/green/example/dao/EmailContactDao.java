package com.green.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.green.example.entity.EmailContact;

public class EmailContactDao extends BaseDao {
	public List<EmailContact> findAll() {
		return new ArrayList<>();
	}
	
	/**
	 * find by email
	 * @param id (email)
	 * @return
	 */
	public EmailContact find(String id) {
		return null;
	}
	
	public List<EmailContact> findByContactId(long contactId) {
		return new ArrayList<>();
	}
	
	public EmailContact create(EmailContact contact) {
		return contact;
	}
	
	public EmailContact update(EmailContact contact) {
		return contact;
	}
	
	public void delete(String id) {
		
	}
}
