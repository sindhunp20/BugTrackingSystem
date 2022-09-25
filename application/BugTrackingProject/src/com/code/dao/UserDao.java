package com.code.dao;

import com.code.bean.User;
import com.code.exception.InvalidUserException;

public interface UserDao {

	User validateUser(String userName, String password) throws InvalidUserException;

}
