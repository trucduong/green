package com.green.example.service;

import com.green.example.dao.UserDao;
import com.green.example.model.User;

public class UserService {
	
	public User authenticate(String username, String password) {
		UserDao dao = new UserDao();
		
		User user = dao.getUser(username);
		if (user == null) {
			return null;
		}
		
		// TODO: check password
		
		return user;
	}

}
