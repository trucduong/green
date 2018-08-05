package com.green.example.dao;

import com.green.example.model.User;

public class UserDao {
	
	public User getUser(String username) {
		// TODO implement
		if ("error".equals(username)) {
			return null;
		}
		
		User user = new User();
		user.setUsername(username);
		
		return user;
		
	}

}
