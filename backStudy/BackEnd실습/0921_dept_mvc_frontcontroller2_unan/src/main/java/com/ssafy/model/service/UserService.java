package com.ssafy.model.service;

import java.sql.SQLException;

import com.ssafy.model.dao.UserDAO;

public class UserService {
	
	UserDAO userDao = new UserDAO();
	public String login(String userId, String password) throws SQLException
	{
		return userDao.login(userId, password);
	}
}
