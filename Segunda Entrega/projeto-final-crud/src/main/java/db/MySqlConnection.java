package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/crud_projeto_squad";/* crud_projeto_squad */
	private static final String USER = "root";
	private static final String PASSWORD = "12345";

	public static Connection createConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver found");

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found. " + e.getMessage());
		}

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connected to database");
			return connection;

		} catch (SQLException e) {
			System.out.println("Not connected to database." + e.getMessage());
			return null;
		}
	}
}
