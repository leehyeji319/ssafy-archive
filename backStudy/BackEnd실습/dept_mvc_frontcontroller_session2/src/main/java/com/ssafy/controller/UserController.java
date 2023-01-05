package com.ssafy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.UserService;

public class UserController implements Controller {

	private UserService userService = new UserService();
	
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
		System.out.println(userId);
		String name = userService.login(userId, password);
		
		if(name != null)
		{
//			Cookie idCookie = new Cookie("userId", userId);
//			Cookie nameCookie = new Cookie("userName", name);
//			
//			idCookie.setPath(request.getContextPath());
//			nameCookie.setPath(request.getContextPath());
//			
//			response.addCookie(idCookie);
//			response.addCookie(nameCookie);
			
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("userName", name);
			
			return new PageInfo(false, "/index.do");
		}
		else
		{
			request.setAttribute("errorMsg", "로그인에 실패했습니다");
			return new PageInfo(true, "/user/login.jsp");
		}
		
	}
	

	protected PageInfo logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		session.invalidate();
		
		return new PageInfo(false, "/index.do");
	}
	
	protected PageInfo loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(true, "/user/login.jsp");
	}
	
}
