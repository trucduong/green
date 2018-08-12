package com.green.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.green.example.entity.Contact;

import utils.Gender;

public class ContactDao extends BaseDao {
	
	private Logger logger = Logger.getLogger(ContactDao.class);

	public List<Contact> findAll() {
		List<Contact> contacts = new ArrayList<>();
		Connection dbConnection = null;
		Statement statement = null;
		String query = "SELECT * FROM contacts";

		try {
			dbConnection = getConnection();
			statement = dbConnection.createStatement();

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Contact item = extractContact(rs);
				contacts.add(item);
			}

		} catch (SQLException e) {
			logger.error("Fail to get contact list.", e);
		} finally {
			closeConnection(dbConnection, statement);
		}
		
		return contacts;
	}
	
	public Contact find(long id) {
		Contact contact = null;
		Connection dbConnection = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM contacts WHERE id = ?";

		try {
			dbConnection = getConnection();
			statement = dbConnection.prepareStatement(query);
			statement.setLong(1, id);

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				contact = extractContact(rs);
			}

		} catch (SQLException e) {
			logger.error("Fail to get contact.", e);
		} finally {
			closeConnection(dbConnection, statement);
		}
		
		return contact;
	}
	
	public List<Contact> findByName(String name) {
		List<Contact> contacts = new ArrayList<>();
		Connection dbConnection = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM contacts WHERE full_name LIKE ?";

		try {
			dbConnection = getConnection();
			statement = dbConnection.prepareStatement(query);
			statement.setString(1, "%" + name + "%");

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Contact item = extractContact(rs);
				contacts.add(item);
			}

		} catch (SQLException e) {
			logger.error("Fail to search contact list.", e);
		} finally {
			closeConnection(dbConnection, statement);
		}
		
		return contacts;
	}
	
	public Contact create(Contact contact) {
		Connection dbConnection = null;
		PreparedStatement statement = null;
		String query = "INSERT INTO contacts(id, full_name, avatar, gender, birth_date, address, note) VALUES(?,?,?,?,?,?,?)";

		try {
			dbConnection = getConnection();
			statement = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, contact.getId());
			statement.setString(2, contact.getName());
			statement.setString(3, contact.getAvatar());
			statement.setString(4, contact.getGender().toString());
			if (contact.getBirthDate() != null) {
				statement.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(contact.getBirthDate()));
			} else {
				statement.setString(5, null);
			}
			statement.setString(6, contact.getAddress());
			statement.setString(7, contact.getNote());

			// execute select SQL stetement
			int result = statement.executeUpdate();

			// get inserted contact id
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (result > 0 && generatedKeys.next()) {
				contact.setId(generatedKeys.getLong(1));
			}
			return contact;

		} catch (SQLException e) {
			logger.error("Fail to create contact.", e);
		} finally {
			closeConnection(dbConnection, statement);
		}
		
		return null;
	}
	
	public Contact update(Contact contact) {
		return contact;
	}
	
	public void delete(long id) {
		
	}
	
	
	private Contact extractContact(ResultSet rs) throws SQLException {
		Contact item = new Contact();
		item.setId(rs.getLong("id"));
		item.setName(rs.getString("full_name"));
		item.setAddress(rs.getString("address"));
		item.setAvatar(rs.getString("avatar"));
		item.setBirthDate(rs.getDate("birth_date"));
		item.setGender(Gender.valueOf(rs.getString("gender")));
		item.setNote(rs.getString("note"));
		return item;
	}
}
