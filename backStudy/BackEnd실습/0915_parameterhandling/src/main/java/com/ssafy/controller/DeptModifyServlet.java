package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

@WebServlet("/dept/modify.do")
public class DeptModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DeptService deptService = new DeptService();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		
		
		// 2.call service
		boolean res = deptService.updateDept(new Dept(deptno, dname, loc));
		
		if (res) {
//			request.getRequestDispatcher("./list.jsp").forward(request, response);
			response.sendRedirect("./list.do");
			return;
		} else {
			response.sendRedirect("./list.do");
			return;
		}
		
	}

}
