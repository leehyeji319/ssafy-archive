package com.ssafy.myhome.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.myhome.model.dto.PageInfoDto;
import com.ssafy.myhome.model.dto.UserDto;
import com.ssafy.myhome.model.service.impl.UserServiceImpl;

public class UserController implements Controller {

	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = request.getServletPath();
		
		if (url.equals("/user/login.do")) {
			return login(request, response);
		} else if (url.equals("/user/register.do")) {
			return register(request, response);
		} else if (url.equals("/user/logout.do")) {
			return logout(request, response);
		} else if (url.equals("/user/login_form.do")) {
			return loginForm(request, response);
		} else if (url.equals("/user/update.do")) {
			return updateUser(request, response);
		} else if (url.equals("/user/delete.do")) {
			return deleteUser(request, response);
		} else if (url.equals("/user/detail.do")) {
			return getUser(request, response);
		}
		
		return null;
	}
	
	protected PageInfoDto register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("usrepwd");
		String userName = request.getParameter("username");
		String address = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		UserDto userDto = new UserDto();
		
		userDto.setUserId(userId);
		userDto.setUserPwd(userPwd);
		userDto.setUserName(userName);
		userDto.setAddress(address);
		userDto.setPhone(phone);
		
		UserServiceImpl.getInstance().registerUser(userDto);
		
		return new PageInfoDto(false, "/index.do");
	}
	
	protected PageInfoDto login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		
//		System.out.println(userId);
//		System.out.println(userPwd);
		
		UserDto userDto = UserServiceImpl.getInstance().login(userId, userPwd);
		
		if (userDto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", userDto.getUserId());
			session.setAttribute("username", userDto.getUserName());
			
			return new PageInfoDto(false, "/index.do");
		} else {
			request.setAttribute("errorMsg", "로그인에 실패했습니다.");
			return new PageInfoDto(true, "/user/login_form.jsp");
		}
	}
	
	protected PageInfoDto logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		return new PageInfoDto(false, "/index.jsp");
	}
	
	protected PageInfoDto loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfoDto(false, "/user/login.jsp");
	}
	
	protected PageInfoDto getUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userid");
		System.out.println(userId);
		UserDto user =  UserServiceImpl.getInstance().getUser(userId);
		System.out.println(user.getAddress());
		request.setAttribute("user", user);
		return new PageInfoDto(true, "/user/mypage_form.jsp");
	}
	
	protected PageInfoDto updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("password");
		String userName = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		UserDto userDto = new UserDto();
		
		userDto.setUserId(userId);
		userDto.setUserPwd(userPwd);
		userDto.setUserName(userName);
		userDto.setAddress(address);
		userDto.setPhone(phone);
		
		UserServiceImpl.getInstance().updateUser(userDto);
		
		HttpSession session = request.getSession();
		session.setAttribute("userid", userDto.getUserId());
		session.setAttribute("username", userDto.getUserName());
		
		return new PageInfoDto(true, "/index.jsp");
		
	}
	
	protected PageInfoDto deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		String userId = request.getParameter("userid");
		UserServiceImpl.getInstance().deleteUser(userId);
		
		return new PageInfoDto(true,"/index.do");
	}
}
