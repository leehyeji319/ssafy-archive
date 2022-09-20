package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.service.DeptService;


@WebServlet("/dept/remove.do")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DeptService deptService = new DeptService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		// 2.call service
		try {
			boolean res = deptService.delete(deptno);
			
			if (res) {
				request.setAttribute("msg", "부서 삭제에 성공하였습니다.");
			} else {
				request.setAttribute("msg", "부서 삭제에 실패하였습니다.");
			}
			request.getRequestDispatcher("./list.do").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("../error.jsp").forward(request, response);
			return;
		}
		
		//3. view에 넘겨주기
		
	}

}
