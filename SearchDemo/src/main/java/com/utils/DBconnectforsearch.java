package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectforsearch {

	public static   Connection getConnection() {
		Connection connection = null;
		String url ="jdbc:mysql://localhost:3306/customerdb";
		String username="root";
		String password = "root";
		
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(url, username, password);
	            System.out.println("Connection made");
	        } catch (ClassNotFoundException e) {
	            System.out.println("JDBC Driver not found: " + e);
	        } catch (SQLException e) {
	            System.out.println("Error getting connection: " + e);
	        }
	        return connection;
	}
}
