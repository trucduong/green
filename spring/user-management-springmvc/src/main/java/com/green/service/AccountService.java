package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.green.dao.AccountDao;
import com.green.entity.Account;
import com.green.exception.MyException;

//@Component
@Service
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	public List<Account> findAll() {
//		List<Account> list = accountDao.findAll();
//		return list;
		
		return accountDao.findAll();
	}
	
	public Account login(String username, String password) throws Exception {
		Account account = accountDao.findByUsername(username);
		
		if (account == null) {
			throw new MyException("Username khong ton tai.");
		}
		
		if (!password.equals(account.getPassword())) {
			throw new MyException("Password khong dung.");
		}
		
		return account;
	}
	
	public Account findByUsername(String username) {
		return accountDao.findByUsername(username);
	}
	
	public boolean insert(Account account) {
		return accountDao.insert(account);
	}

	public boolean update(String username, Account account) {
		return accountDao.update(username, account);
	}
	
	public boolean delete(String username) {
		return accountDao.delete(username);
	}
}
