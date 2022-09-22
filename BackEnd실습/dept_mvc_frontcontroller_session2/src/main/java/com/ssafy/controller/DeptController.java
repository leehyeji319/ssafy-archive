package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;

public class DeptController implements Controller {

	private DeptService deptService = new DeptService();
	
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = request.getServletPath();
		
		if(url.equals("/dept/list.do")) {
			return getDeptList(request, response);
		} else if(url.equals("/dept/detail.do")) {
			return getDeptDetail(request,response);
		}
		else if(url.equals("/dept/modify.do")) {
			
			return modifyDept(request, response);
		} else if(url.equals("/dept/register.do")) {
			return registerDept(request, response);
		} else if(url.equals("/dept/remove.do")) {
			return removeDept(request, response);
		} else if(url.equals("/dept/register_form.do")) {
			return registerForm(request, response);
		} else if (url.equals("/dept/rest/list.do")) {
			return getDeptRestList(request, response);
		}
		
		return null;
	}
	
	protected PageInfo getDeptList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("deptList", deptService.getDepts());
		request.getRequestDispatcher("/dept/list.jsp").forward(request, response);

		return new PageInfo(true, "/dept/list.jsp");
	}
	
	protected DataInfo getDeptRestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Dept> depts = deptService.getDepts();
		
		return new DataInfo("application/json", depts);
	}

	protected PageInfo getDeptDetail(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		// 1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		// 2. call Service
		Dept dept = deptService.getDept(deptno);

		request.setAttribute("dept", dept);
		return new PageInfo(true, "/detail_form.jsp");
	}

	protected PageInfo modifyDept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 0. set param encoding
		request.setCharacterEncoding("utf-8");
		// 1. get param
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");

		boolean res = deptService.updateDept(new Dept(deptno, dname, loc));

		// 3. move page
		if(res)
			request.setAttribute("msg", "부서 수정에 성공했습니다.");
		else
			request.setAttribute("msg", "부서 수정에 실패했습니다.");

		return new PageInfo(true, "/list.do");
	}

	protected PageInfo registerDept(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 0. request parameter encoding 
		request.setCharacterEncoding("utf-8");
		// 1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");

		// 2. verify parameter
		// 3. call service
		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));

		// 4. view page by result
		if(res)
			return new PageInfo(false, "/list.do");
		else {
			request.setAttribute("errorMsg", "등록에 실패하였습니다.");
			return new PageInfo(true, "/register_form.jsp");
		}
	}
	
	protected PageInfo removeDept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		boolean res = deptService.delete(deptno);

		// 3. move page
		if(res)
			request.setAttribute("msg", "부서 삭제에 성공했습니다.");
		else
			request.setAttribute("msg", "부서 삭제에 실패했습니다.");

		return new PageInfo(true, "/list.do");
	}
	
	
	protected PageInfo registerForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(true, "/dept/register_form.jsp");
	}
	

}
