package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.Customer;
import com.utils.DBconnect;

public class CustomerDao {
     Connection conn = DBconnect.findConnection();
     PreparedStatement ps= null;
    public  String insertIntoDB(Customer newCust) {
    	String firstname = newCust.getFirstname();
        String lastname = newCust.getLastname();
        String dob = newCust.getDob();
        String city = newCust.getCity();
        String country = newCust.getCountry();
        String gender = newCust.getGender();
    	String source="success";
    	
    	try {
    		String sql = "insert into customer values('"+ firstname +"','"+lastname +"','" +dob  +"','" + city +"','" + country +"','" +gender+"')";
    		ps = conn.prepareStatement(sql);
    		ps.execute();
    	}catch(Exception E){
    		source ="fail";
    		System.out.println(E);
    	}
		return  source;
    }
}
