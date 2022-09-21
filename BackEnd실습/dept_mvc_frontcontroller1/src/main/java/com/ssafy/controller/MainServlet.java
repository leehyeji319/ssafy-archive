package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.UserService;


@WebServlet(loadOnStartup = 1, urlPatterns = {"*.do", "*.ssafy"}) //url여러개 주는것 ".ssafy" 도 가능
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeptService deptService = new DeptService();
	private UserService userService = new UserService();
	
	@Override
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		application.setAttribute("root", application.getContextPath());
		System.out.println("root set...");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	//callback을 직접 부르는건 별로다.. 태희쌤 방법으로!
	protected void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//공통 전처리
		
		//요청에 따라 sub controller로 분기
		String url = request.getServletPath();
		System.out.println("url: " + url);
		
		PageInfo pageInfo = null;
		
		try {
			if (url.equals("/dept/list.do")) {
				pageInfo = getDeptList(request, response);
			} else if(url.equals("/dept/detail.do")){
				pageInfo = getDeptDetail(request, response);
			} else if (url.equals("/dept/modify.do")) {
				pageInfo = updateDept(request, response);
			} else if (url.equals("/dept/remove.do")) {
				pageInfo = deleteDept(request, response);
			} else if (url.equals("/dept/register.do")) {
				pageInfo = registerDept(request, response);
			} else if (url.equals("/user/login.do")) {
				pageInfo = login(request, response);
			} else if (url.equals("/user/logout.do")) {
				pageInfo = logout(request, response);
			}

			if (pageInfo.isForward()) {
				request.getRequestDispatcher(pageInfo.getPage()).forward(request, response);
				return;
			} else {
				//응답을 어떻게 보내줘야하는지도 여기서 처리
				response.sendRedirect( request.getContextPath() + pageInfo.getPage());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		//공통 후처리
	}
	
	protected PageInfo registerDept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno")); //다 문자열로 온다.
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));

		return new PageInfo(false, "/dept/list.do");
	}
	
	protected PageInfo getDeptList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Dept> depts = deptService.getDepts();
		
		request.setAttribute("deptList", depts);
		return new PageInfo(true, "/dept/list.jsp");
		
	}
	
	protected PageInfo getDeptDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1.get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		// 2. call Service
		Dept dept = deptService.getDept(deptno);
		
		request.setAttribute("dept", dept);
		return new PageInfo(true, "/dept/detail_form.jsp");
		
	}

	protected PageInfo updateDept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//0. set parameter encoding
		request.setCharacterEncoding("utf-8");
		//1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		
		boolean res = deptService.updateDept(new Dept(deptno, dname, loc));

		return new PageInfo(true, "./list.do");
		
	}

	
	protected PageInfo deleteDept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1.get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		// 2.call service
		boolean res = deptService.delete(deptno);
		
		return new PageInfo(true, "/dept/list.do");
		
		
	}
	
	protected PageInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	
		// 1.get parameter
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		String name = userService.login(userId, password); //사용자 유형 가져옴
		
		if (name != null) {
			//login 흔적 남기기
			Cookie idCookie = new Cookie("userId", userId);
			Cookie nameCookie = new Cookie("userName", URLEncoder.encode(name, "utf-8")); //인코딩해서 보내주기
			
			idCookie.setPath(request.getContextPath());
			nameCookie.setPath(request.getContextPath());
			
			response.addCookie(idCookie);
			response.addCookie(nameCookie);
			
			return new PageInfo(false, "/dept/list.do"); //false가 포워딩을 안하겠다는거잖아요? 리퀘스트를 유지할 필요가없어. 
			//리퀘스트를 할때는 ? 유지하거나 토스하고싶을때만 ... 포워딩 단점 : 주소창과 이동화면이 일치하지않는다.
		} else {
			//이건 페이지 이동이 아니니까 
			request.setAttribute("errorMsg", "아이디나 비밀번호가 일치하지 않습니다.");
			return new PageInfo(true, "/user/login.jsp");
		}
		
		
	}
	
	
	protected PageInfo logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Cookie cookies[] = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userId") || cookie.getName().equals("userName")) {
					cookie.setPath(request.getContextPath()); //꺼낸쿠키라서 괜찮을 줄 알았는데 패쓰 설정 다시 해줘야하네 ... 
					cookie.setMaxAge(0); //0으로 설정하면 쿠키삭제
					response.addCookie(cookie);
				}
			}
		}
		
		return new PageInfo(false, "/index.jsp"); //forwarding안하고~
	}
	

}
