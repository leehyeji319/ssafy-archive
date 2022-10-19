package com.ssafy.empapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.empapp.model.dto.DataInfo;
import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.dto.PageInfo;
import com.ssafy.empapp.model.service.DeptService;
import com.ssafy.empapp.model.service.DeptServiceImpl;

public class DeptController implements Controller {

	private DeptService deptService = new DeptServiceImpl();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		if(url.equals("/dept/list.do")) {
			return getDeptList(request, response);
		}
		else if(url.equals("/dept/detail.do")) {
			return getDeptDetail(request, response);
		}
		else if(url.equals("/dept/register.do")) {
			return registerDept(request, response);
		}
		else if(url.equals("/dept/register_form.do")) {
			return registerForm(request, response);
		}
		else if(url.equals("/dept/remove.do")) {
			return removeDept(request, response);
		}
		else if(url.equals("/dept/modify.do")) {
			return modifyDept(request, response);
		}
		else if(url.equals("/dept/rest/list.do")) {
			return getDeptRestList(request, response);
		}
		return null;
	}
	
	protected PageInfo getDeptList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Dept> depts = deptService.getDepts();
		request.setAttribute("deptList", depts);
		return new PageInfo(true, "/dept/list.jsp");
	}
	
	protected PageInfo getDeptDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		Dept dept = deptService.getDept(deptno);
		request.setAttribute("dept", dept);
		return new PageInfo(true, "/dept/detail_form.jsp");
	}
	
	protected PageInfo registerDept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));
		if(res) {
			return new PageInfo(false, "/dept/list.do");
		}else {
			request.setAttribute("errorMsg", "등록에 실패하였습니다.");
			return new PageInfo(true, "/dept/register_form.jsp");
		}
	}
	
	protected PageInfo removeDept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		boolean res = deptService.deleteDept(deptno);
		if (res) {
			request.setAttribute("msg", "부서 삭제에 성공하였습니다.");
		} else {
			request.setAttribute("msg", "부서 삭제에 실패하였습니다.");
		}
		return new PageInfo(true, "/dept/list.do");
	}
	
	protected PageInfo modifyDept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		boolean res = deptService.modifyDept(new Dept(deptno, dname, loc));
		if (res) {
			request.setAttribute("msg", "부서 수정에 성공하였습니다.");
		} else {
			request.setAttribute("msg", "부서 수정에 실패하였습니다.");
		}
		return new PageInfo(true, "/dept/list.do");
	}
	
	protected DataInfo getDeptRestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Dept> depts = deptService.getDepts();
		return new DataInfo("application/json", depts);
	}

	protected PageInfo registerForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(true, "/dept/register_form.jsp");
	}
}
