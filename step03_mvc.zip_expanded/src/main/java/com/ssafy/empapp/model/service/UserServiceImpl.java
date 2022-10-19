package com.ssafy.empapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.UserDAO;
import com.ssafy.empapp.model.dao.UserDAOImpl;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDao;
	
	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public String login(String userId, String password) throws Exception {
	
	    return userDao.login(userId, password);
	}
}