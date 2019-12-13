package com.aca.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBUtil {
	private static String connectionUrl =
			"jdbc:mariadb://localhost:3306/northwindtng?user=root&password=rfh987654";
	
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
