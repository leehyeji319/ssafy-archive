package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dto.Dept;

public class DeptService {

	private DeptDAO deptDao = new DeptDAO();
	
	public boolean registerDept(Dept dept) throws Exception {
		//부서 등록
		return deptDao.insertDept(dept) > 0;
	}
	
	public List<Dept> getDepts() throws Exception {
		//부서리스트 조회
		return deptDao.selectDepts();
	}
	
	public Dept getDept(int deptno) throws Exception {
		return deptDao.selectDept(deptno);
	}
	
	public boolean delete(int deptno) throws Exception{
		return deptDao.deleteDept(deptno) > 0;
	}
	
	public boolean updateDept(Dept dept) throws Exception {
		return deptDao.updateDept(dept) > 0;
	}
}
