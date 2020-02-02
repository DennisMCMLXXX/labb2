package com.tutorialspoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private static String PASSWORD = "godisegott";

// ANSLUTER TILL DATABASEN
	public static Connection getConnection() {

		try {
			String url = "jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=CET";
			Connection connection = DriverManager.getConnection(url, "root", PASSWORD);
			return connection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.err.println("\nDet gick inte att ansluta till databasen!" + "\nProgrammet Avslutas!");
			System.exit(0);
			return null;
		}
	}
}
