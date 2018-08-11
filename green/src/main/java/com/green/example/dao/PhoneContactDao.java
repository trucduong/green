package com.green.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.green.example.entity.PhoneContact;

public class PhoneContactDao extends BaseDao {
	public List<PhoneContact> findAll() {
		return new ArrayList<>();
	}
	
	/**
	 * find by email
	 * @param id (email)
	 * @return
	 */
	public PhoneContact find(String id) {
		return null;
	}
	
	public List<PhoneContact> findByContactId(long contactId) {
		return new ArrayList<>();
	}
	
	public PhoneContact create(PhoneContact contact) {
		return contact;
	}
	
	public PhoneContact update(PhoneContact contact) {
		return contact;
	}
	
	public void delete(String id) {
		
	}
}
