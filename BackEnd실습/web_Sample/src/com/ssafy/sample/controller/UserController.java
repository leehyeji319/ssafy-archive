package com.ssafy.sample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.model.dto.PageInfo;
import com.ssafy.sample.model.dto.Product;
import com.ssafy.sample.model.service.UserService;

public class UserController implements Controller {
	
	private UserService userService = new UserService();

	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = request.getServletPath();
		
		if (url.equals("/user/login.do")) {
			return login(request, response);
		} else if (url.equals("/user/logout.do")) {
			return logout(request, response);
		} else if (url.equals("/user/login_form.do")) {
			return loginForm(request, response);
		}
		
		return null;
	}
	
	protected PageInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		String name = userService.login(userId, password);
		
		if (name != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("password", password);
			
			return new PageInfo(false, "/index.do");
			
		} else {
			request.setAttribute("errorMsg", "아이디가 없습니다.");
			return new PageInfo(true, "/user/login.jsp");
		}
	}
	
	protected PageInfo logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		return new PageInfo(false, "/index.jsp");
	}
	
	protected PageInfo loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return new PageInfo(false, "/user/login.jsp");
	}
}
