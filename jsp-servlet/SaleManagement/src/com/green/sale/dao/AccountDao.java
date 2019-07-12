package com.green.sale.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.green.sale.entity.Account;
import com.green.sale.utils.ApplicationConfig;

public class AccountDao {

	public Account find(String code) {
		return null;
	}

	public List<Account> findAll() {
		// học viên thực hiện phần này
		List<Account> list = new ArrayList<>();
		
		return list;
	}

	public boolean update(String code, Account account) {
		// học viên thực hiện phần này
		boolean result = false;

		return result;
	}

	public boolean delete(String code) {
		// học viên thực hiện phần này
		boolean result = false;

		return result;
	}

	public Account findByEmail(String email) {
		// sinh viên tự thực hiện phần này
		return null;
	}

	public boolean insert(Account account) {
		int count = 0;
		try {
			Class.forName(ApplicationConfig.getConfig("database.driver"));
			Connection con = DriverManager.getConnection(ApplicationConfig.getConfig("database.url"),
					ApplicationConfig.getConfig("database.username"), ApplicationConfig.getConfig("database.password"));

			String sql = "INSERT INTO account(email, password, full_name, birth_date, address, gender, image)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, account.getEmail());
			st.setString(2, account.getPassword());
			st.setString(3, account.getFullName());
			st.setDate(4, new Date(account.getBirthDate().getTime()));
			st.setString(5, account.getAddress());
			st.setString(6, account.getGender().toString());
			st.setString(7, account.getImage());

			count = st.executeUpdate();

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count > 0;
	}

	public boolean isExist(String email) {
		boolean result = false;
		try {
			Class.forName(ApplicationConfig.getConfig("database.driver"));
			Connection con = DriverManager.getConnection(ApplicationConfig.getConfig("database.url"),
					ApplicationConfig.getConfig("database.username"), ApplicationConfig.getConfig("database.password"));

			String sql = "SELECT email FROM account WHERE email = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);

			ResultSet rs = st.executeQuery();
			result = rs.next();

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
