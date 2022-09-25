package com.code.service;

import com.code.bean.User;
import com.code.exception.InvalidUserException;

public interface UserService {

	User validateUser(String userName, String password) throws InvalidUserException;

}
