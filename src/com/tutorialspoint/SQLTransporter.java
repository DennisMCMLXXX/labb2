package com.tutorialspoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLTransporter {

	public boolean getUsers(final String dBName) throws SQLException {

		Statement statement = getSQLSetup(dBName);
		String sqlStatement = "SELECT * FROM ppl;";
		if (statement.execute(sqlStatement)) {
			return getUsersFromDB(statement);
		}

		return false;
	}

	public boolean getUsers(final String dBName, final int idnumber) throws SQLException {
		Statement statement = getSQLSetup(dBName);
		statement.executeUpdate("USE " + dBName + ";");
		String sqlStatement = "SELECT * FROM ppl WHERE id LIKE " + idnumber + ";";
		if (statement.execute(sqlStatement)) {
			return getUsersFromDB(statement);
		}

		return false;
	}

	/**
	 * kunde inte använda mig av denna tjänst för jag fick felmeddelande att denna
	 * och id kolliderade. Vet ej varför.
	 */
//	public boolean getUsers(final String dBName, final String name) throws SQLException {
//		Statement statement = getSQLSetup(dBName);
//		statement.executeUpdate("USE " + dBName + ";");
//		String sqlStatement = "SELECT * FROM ppl WHERE name LIKE " + name + ";";
//		if (statement.execute(sqlStatement)) {
//			return getUsersFromDB(statement);
//		}
//
//		return false;
//	}

	private Statement getSQLSetup(String dBName) throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection connection = MySqlConnection.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate("USE " + dBName + ";");
		return statement;
	}

	private boolean getUsersFromDB(Statement statement) throws SQLException {
		List<User> userList = new ArrayList<User>();
		ResultSet resultSet;
		resultSet = statement.getResultSet();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String proffesion = resultSet.getString("profession");
			User user = new User(id, name, proffesion);
			userList.add(user);
		}

		Processor.setUserList(userList);
		return true;
	}
}
