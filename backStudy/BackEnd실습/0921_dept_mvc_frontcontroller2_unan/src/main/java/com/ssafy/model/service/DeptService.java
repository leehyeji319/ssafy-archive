package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dto.Dept;

public class DeptService {
	
	private DeptDAO deptDao = new DeptDAO();
	
	public boolean registerDept(Dept dept) throws Exception {
		// 부서 등록
		return deptDao.insertDept(dept) > 0;
	}
	
	public List<Dept> getDepts() throws Exception{
		// 부서 리스트 조회
		return deptDao.selectDepts();
	}
	
	public Dept getDept(int deptNo) throws Exception {
		return deptDao.selectDept(deptNo);
	}
	
	public boolean deleteDept(int deptNo) throws Exception {
		return deptDao.deleteDept(deptNo);
	}
	
	public boolean updateDept(Dept dept) throws Exception {
		return deptDao.updateDept(dept);
	}
}
