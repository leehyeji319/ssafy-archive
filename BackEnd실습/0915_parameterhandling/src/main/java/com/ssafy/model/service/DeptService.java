package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dto.Dept;

public class DeptService {

	private DeptDAO deptDao = new DeptDAO();
	
	public boolean registerDept(Dept dept) {
		//부서 등록
		return deptDao.insertDept(dept) > 0;
	}
	
	public List<Dept> getDepts() {
		//부서리스트 조회
		return deptDao.selectDepts();
	}
	
	public Dept getDept(int deptno) {
		return deptDao.selectDept(deptno);
	}
	
	public boolean delete(int deptno) {
		return deptDao.deleteDept(deptno);
	}
	
	public boolean updateDept(Dept dept) {
		return deptDao.updateDept(dept);
	}
}
