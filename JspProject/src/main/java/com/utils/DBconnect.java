package com.utils;
import java.sql.*;
public class DBconnect {
	String url = "jdbc:mysql://localhost:3306/customerdb";
	String username = "root";
	String password = "root";
	
	
	public Connection findConnection() {
		Connection conn= null;
		
		try {
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("connection made");
		}catch(SQLException e){
			System.out.println("error found "+ e);
		}
		
		return conn;
	}
}
