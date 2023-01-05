package com.ssafy.empapp.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		if(userId == null) {
			response.sendRedirect(request.getContextPath() + "/user/login_form.do");
			return false;
		}
		return true;
	}
}
