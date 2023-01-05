package com.ssafy.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.model.dto.PageInfo;

public class HomeController implements Controller {

	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = request.getServletPath();
		if (url.equals("/index.do")) {
			return index(request, response);
		}
		
		return null;
	}
	
	protected PageInfo index(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		return new PageInfo(true, "/index.jsp");
	}
}
