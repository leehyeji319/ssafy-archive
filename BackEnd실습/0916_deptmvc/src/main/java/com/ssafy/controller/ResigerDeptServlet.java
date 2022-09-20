package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		try {
			boolean res = deptService.registerDept(new Dept(deptno, dname, loc));
			
			//4. view page by result
			//먼저 응답을 해야하니까 응답객체 셋팅을 먼저합시다.
			if (res) {
			response.sendRedirect("./list.do"); //redirect는 무조건 get방식 
//				request.getRequestDispatcher("./list.do").forward(request, response); //포워드로 하면 들어온 request의 방식으로 되는거죠
				return;
			} else {
//				request.setAttribute("errorMsg", "등록에 실패하였습니다.");
//				RequestDispatcher rd = request.getRequestDispatcher("../error.jsp");
//				rd.forward(request, response);
//				return;
				
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			request.setAttribute("errorMsg", "등록에 실패하였습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("../error.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
