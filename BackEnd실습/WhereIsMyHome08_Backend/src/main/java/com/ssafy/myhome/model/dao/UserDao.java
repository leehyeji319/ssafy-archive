package com.ssafy.myhome.model.dao;

import java.sql.SQLException;

import com.ssafy.myhome.model.dto.UserDto;

public interface UserDao {
	
	void registerUser (UserDto userDto) throws SQLException;
	
	UserDto login(String userId, String userPwd) throws SQLException;
	
	UserDto getUser(String userId) throws SQLException;
	
	void updateUser(UserDto userDto) throws SQLException;
	
	void deleteUser(String userId) throws SQLException;

}
