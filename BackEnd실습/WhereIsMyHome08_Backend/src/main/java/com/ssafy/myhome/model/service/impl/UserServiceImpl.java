package com.ssafy.myhome.model.service.impl;

import java.sql.SQLException;

import com.ssafy.myhome.model.dao.impl.UserDaoImpl;
import com.ssafy.myhome.model.dto.UserDto;
import com.ssafy.myhome.model.service.UserService;

public class UserServiceImpl implements UserService{
	
	private static UserServiceImpl instance;
	
	private UserServiceImpl() {}
	
	public static UserServiceImpl getInstance() {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}

	@Override
	public void registerUser(UserDto userDto) throws Exception {
		UserDaoImpl.getInstance().registerUser(userDto);
		
	}

	@Override
	public UserDto login(String userId, String userPwd) throws Exception {
//		System.out.println(userId);
		return UserDaoImpl.getInstance().login(userId, userPwd);
	}

	@Override
	public UserDto getUser(String userId) throws Exception {
//		System.out.println(userId);
		return UserDaoImpl.getInstance().getUser(userId);
	}

	@Override
	public void updateUser(UserDto userDto) throws Exception {
		UserDaoImpl.getInstance().updateUser(userDto);
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		UserDaoImpl.getInstance().deleteUser(userId);
		
	}

}
