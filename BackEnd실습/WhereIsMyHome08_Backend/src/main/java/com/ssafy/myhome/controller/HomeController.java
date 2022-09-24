package com.ssafy.myhome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.myhome.model.dto.PageInfoDto;

public class HomeController implements Controller {

	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = request.getServletPath();
		if (url.equals("/index.do")) {
			return index(request, response);
		}
		
		return null;
	}
	
	protected PageInfoDto index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return new PageInfoDto(true, "/index.jsp");
	}

}
