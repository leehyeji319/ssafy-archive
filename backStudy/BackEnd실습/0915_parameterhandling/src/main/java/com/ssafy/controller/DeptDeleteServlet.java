package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.service.DeptService;


@WebServlet("/dept/delete.do")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DeptService deptService = new DeptService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		// 2.call service
		boolean res = deptService.delete(deptno);
		
		if (res) {
			request.getRequestDispatcher("./list.do").forward(request, response);
			return;
		} else {
			request.setAttribute("errorMsg", "해당하는 부서번호가 없습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("./list.do");
			rd.forward(request, response);
			return;
		}
		
		//3. view에 넘겨주기
		
	}

}
