package com.ssafy.sample.model.service;

import java.sql.SQLException;

import com.ssafy.sample.model.dao.UserDAO;

public class UserService {

	private UserDAO userDAO = new UserDAO();
	
	public String login(String userId, String password) throws SQLException {
		
		return userDAO.login(userId, password);
	}
}
