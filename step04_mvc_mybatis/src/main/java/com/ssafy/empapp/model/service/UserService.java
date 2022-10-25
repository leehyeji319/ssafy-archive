package com.ssafy.empapp.model.service;

public interface UserService {

	String login(String userId, String password) throws Exception;
	boolean signup(String userId, String password, String userName, String userEmail) throws Exception;
}