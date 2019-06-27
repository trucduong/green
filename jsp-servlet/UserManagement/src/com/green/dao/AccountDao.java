package com.green.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.green.entity.Account;

public class AccountDao {
	
	/**
	 * Tim thong tin account theo username
	 * @param username
	 * @return Account
	 */
	public Account findByUsername(String username) {
		Account account = null;
		try {
			Class.forName(DBConfig.JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DBConfig.DB_URL);
			String sql = "SELECT username, password, full_name, email"
						+ " FROM account"
						+ " WHERE username = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			
			ResultSet r = st.executeQuery();
			if (r.next()) {
				account = new Account();
				account.setUsername(r.getString("username"));
				account.setPassword(r.getString("password"));
				account.setFullName(r.getString("full_name"));
				account.setEmail(r.getString("email"));
			}
			
			r.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return account;
	}
}
