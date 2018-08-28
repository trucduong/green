package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class JdbcUtils {
	private static Logger logger = Logger.getLogger(JdbcUtils.class);
	
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String CONNECTION_TYPE = "jdbc:mysql";
	private static final String SERVER = "localhost:3306";
	private static final String DB_NAME = "green";
	private static final String USERNAME = "green";
	private static final String PASSWORD = "green";

	public static Connection getConnection() throws SQLException {
		try {

			Class.forName(DRIVER_CLASS);
			Connection connection = DriverManager.getConnection(CONNECTION_TYPE + "://" + SERVER + "/" + DB_NAME + "?useSSL=false",
					USERNAME, PASSWORD);
			return connection;

		} catch (ClassNotFoundException e) {
			throw new SQLException("DB Connection Driver class not found!");
		}
	}

	public static void closeConnection(Connection connection) {
		closeConnection(connection, null);
	}

	public static void closeConnection(Connection connection, Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			logger.error("Fail to close connection!", e);
		}
	}
}
