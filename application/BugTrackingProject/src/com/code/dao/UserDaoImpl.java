package com.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.code.bean.User;
import com.code.exception.InvalidUserException;

public class UserDaoImpl implements UserDao {

	static Connection conn;
	static PreparedStatement pgetLoginDetails,pgetUserDetails;
	static {
		conn = DBUtil.getMyConnection();
		try {
			//to obtain user id from login table acc. to email and password given
			pgetLoginDetails=conn.prepareStatement("select userid from logintable where email = ? and password = ?");
			
			//to get details of user by user id
			pgetUserDetails=conn.prepareStatement("select * from usertable where userid = ?");
		} catch (SQLException e) {

			System.out.println("Failed to connect to database");
			
		}
	}

	
	
	@Override
	public User validateUser(String userName, String password) throws InvalidUserException  {
			
		try {
			pgetLoginDetails.setString(1, userName);
			pgetLoginDetails.setString(2, password);
			ResultSet rs = pgetLoginDetails.executeQuery();
			if(rs.next()) {
				pgetUserDetails.setInt(1, rs.getInt(1));
				ResultSet rs1 = pgetUserDetails.executeQuery();
				if(rs1.next()) {
					
					return new User(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
				}else {				
					return null;
				}
			}
			else {					
				return null;			
			}
			} catch (SQLException e) {
				
				throw new InvalidUserException("Invalid username or password. Please try again.");
			}
		
			
	}

}
