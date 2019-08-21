package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.green.entity.Account;

//@Component
@Repository
public class AccountDao {
	
	@Autowired
	private SessionFactory factory;
	
	/**
	 * Tim thong tin account theo username
	 * @param username
	 * @return Account
	 */
	public Account findByUsername(String username) {
		Session session = factory.openSession();		
		Account account = session.find(Account.class, username);
		session.close();
		
		return account;
	}
	
	/**
	 * Get all accounts from DB
	 * @return
	 */
	public List<Account> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Account");
		List<Account> accounts = query.getResultList();
		session.close();
		
		return accounts;
	}
	
	/**
	 * Insert
	 * executeUpdate
	 */
	public boolean insert(Account account) {
		try {
			Session session = factory.openSession();
			session.save(account);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Update
	 */
	public boolean update(String username, Account account) {
		try {
			Session session = factory.openSession();
			session.update(account);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Delete
	 */
	public boolean delete(String username) {
		try {
			Session session = factory.openSession();
			Account account = session.find(Account.class, username);
			session.remove(account);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
