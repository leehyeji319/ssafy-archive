package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

@WebServlet("/dept/list.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptService deptService = new DeptService();
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dept> depts = deptService.getDepts();
		
		request.setAttribute("deptList", depts);
		
		request.getRequestDispatcher("/dept/list.jsp").forward(request, response);
//		response.sendRedirect("./list.jsp"); //응답이 다시와서 새로 요청한 새페이지: deptList가 없음 저기엔. 아 이건 리다이렉션이 안되는구나,...
		return; //페이지 이동 코드 밑에 return을 둬서 실수 방지하는게 좋다.
		//컨트롤러가 보내준거받아서 List.jsp에 뿌린다
	}
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
