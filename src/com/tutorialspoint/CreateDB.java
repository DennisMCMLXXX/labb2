package com.tutorialspoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
	
	public void createDataBase(String dBName) {

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = MySqlConnection.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dBName);
			statement.executeUpdate("USE " + dBName + ";");
			statement.executeUpdate(
					"CREATE TABLE ppl(id int NOT NULL AUTO_INCREMENT UNIQUE, name VARCHAR(255), profession VARCHAR(255));");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Dennis','Student');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Dennis','Trainee');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Dennis','Systemutvecklare');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Bengt','IT-Aarkitekt');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Calle','Systemutvecklare');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Mona','Testare');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Frida','Krav-analytiker');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Solveig','Teamledare');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Mikael','Enhetschef');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Christina','General direktör');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Jan','Överste direktör');");
			statement.executeUpdate(
					"INSERT INTO ppl(name, profession) VALUES('Liselotte','Systemutvecklare / handledare');");
			statement.executeUpdate("INSERT INTO ppl(name, profession) VALUES('Kent','Linux tekniker');");
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
