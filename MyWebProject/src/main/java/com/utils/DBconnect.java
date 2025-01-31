package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
    static String url = "jdbc:mysql://localhost:3306/customerdb";
    static String username = "root";
    static String password = "root";

    public static  Connection findConnection() {
        Connection connection = null;
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

	
//	public static void main(String args[]) {
//		 Connection connection =null;
//		 PreparedStatement ps= null;
//		  try {
//			   connection = DriverManager.getConnection(url,username,password);
//			   String sql = "insert into customer values('sahil','gusain','27-08-2024','dehradun','India','male')";
//	    		ps = connection.prepareStatement(sql);
//	    		ps.execute();
//			   System.out.println("connection made");
//			  
//		  }catch(SQLException e){
//			  System.out.println(e);
//		  }
//	}
