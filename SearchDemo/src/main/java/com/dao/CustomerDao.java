package com.dao;

import java.sql.Connection;

import com.utils.DBconnectforsearch;



public class CustomerDao {
		static Connection conn =  DBconnectforsearch.getConnection();
}
