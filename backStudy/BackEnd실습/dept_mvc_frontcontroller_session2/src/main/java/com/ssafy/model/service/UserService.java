package com.ssafy.model.service;

import com.ssafy.model.dao.UserDAO;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	
	public String login(String userId, String password) throws Exception {
		
			
		// 로그인 DB 작업
		return userDao.login(userId, password);
			
		
		
	}

}
