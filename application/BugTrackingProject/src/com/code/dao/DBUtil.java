package com.code.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static Connection conn=null;

	public static Connection getMyConnection() {

		if(conn==null) {
			try {
				String url = "jdbc:mysql://localhost:3306/codefury";
		        String user = "root";
		        String password = "root";
		        
		        Class.forName("com.mysql.jdbc.Driver");
	        
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
		           System.out.println("Connected to database ");
		    }
			} catch (SQLException e) {
				System.out.println("Connection not done derby ");
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
		}
		return conn;
	}
	
	public static void closeMyConnection() {

		try {
			conn.close();
		} catch (SQLException e) {
			
			
		}
		
	}

}
