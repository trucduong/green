package com.green.example.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.example.entity.Account;

@Repository
public class AccountDao {
	
	@Autowired
    private SessionFactory sessionFactory;

	public Account find(String username) {
		return sessionFactory.openSession().find(Account.class, username);
	}
	
}
