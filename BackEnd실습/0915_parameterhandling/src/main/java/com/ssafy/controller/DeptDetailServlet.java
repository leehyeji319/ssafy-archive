package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

@WebServlet("/dept/detail.do")
public class DeptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeptService deptService = new DeptService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		// 2. call Service
		Dept dept = deptService.getDept(deptno);
		
		// 3. view에게 넘겨주기 (직접 줄 수 없으니 어딘가에 저장하고 share하도록 해야함)
		// 내장 객체(session, context 등..) 어디에 저장할지는 이 데이터의 성격에 의해 정해진다. 
		request.setAttribute("dept", dept);
		//request를 넘겨줄땐 무족권 forward!!
		request.getRequestDispatcher("./detail_form.jsp").forward(request, response);
		return;
		
	}

}
