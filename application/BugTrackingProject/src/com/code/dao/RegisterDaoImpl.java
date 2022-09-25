package com.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.code.exception.UserNotFoundException;

public class RegisterDaoImpl implements RegisterDao {

	static Connection conn;
	static PreparedStatement pgetbyemail, pgetbypass; // creating prepared statements
	static {
		conn = DBUtil.getMyConnection();
		try {
			// query to verify email and role existence
			pgetbyemail = conn.prepareStatement("select * from usertable where email=? and type=?");

			// query to store user given password in login table
			pgetbypass = conn.prepareStatement(" insert into  logintable(email,password,userid)  values(?,?,?)");

		} catch (SQLException e) {
			System.out.println("Failed to connect to database");
		}

	}

	// method for verifying existence of email and role given by user for
	// registration
	public int emailExistValidation(String email, String role) throws UserNotFoundException {

		int id = 0;

		try {
			pgetbyemail.setString(1, email);
			pgetbyemail.setString(2, role);
			ResultSet rs = pgetbyemail.executeQuery();
			if (rs.next()) {

				id = Integer.parseInt(rs.getString(1));// Retrieving the user id and returning for validation

				return id;
			}

		} catch (SQLException e) {
			throw new UserNotFoundException("User not found ! Please try again !");
		}

		return 0;

	}

	@Override

	public boolean storePassword(String pass, String email, int userid) throws UserNotFoundException {

		boolean status = false;
		int i = 0;
		try {

			pgetbypass.setString(1, email);
			pgetbypass.setString(2, pass);
			pgetbypass.setLong(3, userid);

			i = pgetbypass.executeUpdate();
			if (i != 0) {
				status = true;
			}

		} catch (SQLException e) {
			throw new UserNotFoundException("User not found ! Please try again !");
		}

		return status;
	}

}
