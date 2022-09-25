package com.code.bean;

public class Developer extends User{

	//default constructor
	public Developer() {
		
		super();
	}

	//parameterized constructor
	public Developer(int userId, String userName, String email, String typeOfUser) {
		
		super(userId, userName, email, typeOfUser);
	}

}
