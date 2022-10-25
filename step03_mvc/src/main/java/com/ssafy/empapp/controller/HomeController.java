package com.ssafy.empapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//이런 분기 코드 이제 필요없다
/*	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		if(url.equals("/index.do"))
			return index(request, response);
		return null;
	}
*/

	@RequestMapping({"/index.do", "/"})
	protected String index() throws Exception { //String타입을 리턴
		return "index"; //prefix설정해놨으니까 / . jsp이거 없어도 됨
	}
	
}
