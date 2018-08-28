package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class ConnectionUtils {
	private static Logger logger = Logger.getLogger(ConnectionUtils.class);

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
