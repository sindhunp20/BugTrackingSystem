package com.code.service;

import com.code.bean.User;
import com.code.dao.UserDao;
import com.code.dao.UserDaoImpl;
import com.code.exception.InvalidUserException;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public User validateUser(String userName, String password) throws InvalidUserException {
		return userDao.validateUser(userName, password);
	}

}
