package com.ssafy.empapp.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
	//viewpage보여주기 전에도 intercepter탈 수 있다. 모든 뷰는 컨트롤러를 타야돼. 우리가 숨겨놧으니까.그래서 인터셉터를 적용받을 수있는거야
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		if(userId == null) {
			System.out.println("로그인 안 한 상태~~~");
			response.sendRedirect(request.getContextPath()+"/user/login_form.do");
			return false; //체이닝 안탐
		}
		return true;
	} //이걸 servlet-context에서 처리해줘 왜? 인터셉터는 컨트롤러에 관련된거니까
	

}
