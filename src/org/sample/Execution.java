package org.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Execution {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","surya");
		String s = "Select * from Employees";
		PreparedStatement prepareStatement = connection.prepareStatement(s);
		ResultSet executeQuery = prepareStatement.executeQuery();
		while (executeQuery.next()) {
			String string = executeQuery.getString("first_name");
			System.out.println(string);
		}
		connection.close();
		System.out.println("JDBC Connection was Done");
	}

}
