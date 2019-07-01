package com.green.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			Connection con = DriverManager
					.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
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
	
	/**
	 * Get all accounts from DB
	 * @return
	 */
	public List<Account> findAll() {
		List<Account> list = new ArrayList<>();
		try {
			Class.forName(DBConfig.JDBC_DRIVER);
			Connection con = DriverManager
					.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
			String sql = "SELECT username, password, full_name, email"
						+ " FROM account";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet r = st.executeQuery();
			while (r.next()) {
				Account account = new Account();
				account.setUsername(r.getString("username"));
				account.setPassword(r.getString("password"));
				account.setFullName(r.getString("full_name"));
				account.setEmail(r.getString("email"));
				
				list.add(account);
			}
			
			r.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Insert
	 * executeUpdate
	 */
	public boolean insert(Account account) {
		int count = 0;
		try {
			Class.forName(DBConfig.JDBC_DRIVER);
			Connection con = DriverManager
					.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
			String sql = "INSERT INTO Account (username, password, full_name, email)"
						+ " VALUES (?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, account.getUsername());
			st.setString(2, account.getPassword());
			st.setString(3, account.getFullName());
			st.setString(4, account.getEmail());
			
			count = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count > 0;
	}
	
	/**
	 * Update
	 */
	public boolean update(String username, Account account) {
		int count = 0;
		try {
			Class.forName(DBConfig.JDBC_DRIVER);
			Connection con = DriverManager
					.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
			String sql = "UPDATE Account"
						+ "SET password = ?, full_name = ?, email = ?"
						+ "WHERE username = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, account.getPassword());
			st.setString(2, account.getFullName());
			st.setString(3, account.getEmail());
			st.setString(4, account.getUsername());
			
			count = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count > 0; 
	}
	
	/**
	 * Delete
	 */
	public boolean delete(String username) {
		int count = 0;
		try {
			Class.forName(DBConfig.JDBC_DRIVER);
			Connection con = DriverManager
					.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
			String sql = "DELETE FROM Account"
						+ "WHERE username = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			
			count = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count > 0; 
	}
}
