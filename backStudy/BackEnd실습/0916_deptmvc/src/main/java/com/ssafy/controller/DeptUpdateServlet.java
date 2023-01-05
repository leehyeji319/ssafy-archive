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
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DeptService deptService = new DeptService();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. set parameter encoding
		request.setCharacterEncoding("utf-8");
		//1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		
		
		// 2.call service
		try {
			boolean res = deptService.updateDept(new Dept(deptno, dname, loc));
			
			// 3.move page by result
			/*
			if (res) {
				//목록으로 가라
//			request.getRequestDispatcher("./list.jsp").forward(request, response); //포워드로 보내면 안되지..;
				response.sendRedirect("./list.do"); //do 를 불러야지
				return;
			} else {
				response.sendRedirect("./list.do");
				return;
			}
			*/
			
			//===쌤 코드===//
			if (res) {
				request.setAttribute("msg", "부서 수정에 성공하였습니다.");
			} else {
				request.setAttribute("msg", "부서 수정에 실패하였습니다.");
			}
			request.getRequestDispatcher("./list.do").forward(request, response);
//		response.sendRedirect("./list.do");
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("../error.jsp").forward(request, response);
			return;
		}
	}

}
