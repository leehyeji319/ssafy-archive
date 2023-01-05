package com.ssafy.myhome.model.service;

import java.sql.SQLException;

import com.ssafy.myhome.model.dto.UserDto;

public interface UserService {
	
	void registerUser (UserDto userDto) throws Exception;
	
	UserDto login(String userId, String userPwd) throws Exception;
	
	UserDto getUser(String userId) throws Exception;
	
	void updateUser(UserDto userDto) throws Exception;
	
	void deleteUser(String userId) throws Exception;
}
