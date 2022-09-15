package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

@WebServlet("/dept/register.do")
public class ResigerDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptService deptService = new DeptService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. request parameter encoding : 요청파라미터 인코딩
		request.setCharacterEncoding("utf-8"); //메세지의 바디부분에 인코딩을 적용하니까 get방식에는 안됩니다.
		//1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno")); //다 문자열로 온다.
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		//2. verify parameter: 데이터가 올바른지 검증을 한다.
		
		//3. call service: 올바르게 왔다면 서비스를 부른다.
		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));
		
		//4. view page by result
		//먼저 응답을 해야하니까 응답객체 셋팅을 먼저합시다.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (res) {
			out.println("<htnl><body>");
			out.println("<h2>등록 성공 </h2>");
			out.println("</body></html>");
		} else {
			out.println("<htnl><body>");
			out.println("<h2>등록 실패 </h2>");
			out.println("</body></html>");
		}
	}

}
