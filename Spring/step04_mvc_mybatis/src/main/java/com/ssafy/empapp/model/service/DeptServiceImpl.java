package com.ssafy.empapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.DeptDAO;
import com.ssafy.empapp.model.dto.Dept;

@Service
// Model : B/L
public class DeptServiceImpl implements DeptService {

	private DeptDAO deptDao;
	
	@Autowired
	public DeptServiceImpl(DeptDAO deptDao) {
		super();
		this.deptDao = deptDao;
	}
	
	@Override
	public boolean registerDept(Dept dept) throws Exception  {
		// 부서 등록
		return deptDao.insertDept(dept) > 0;
	}
	@Override
	public List<Dept> getDepts() throws Exception {
		// 부서리스트 조회
		return deptDao.selectDepts();
	}
	@Override
	public Dept getDept(int deptno) throws Exception {
		// 부서조회
		return deptDao.selectDept(deptno) ;
	}
	@Override
	public boolean modifyDept(Dept dept) throws Exception {
		// 부서 수정
		return deptDao.updateDept(dept) > 0;
	}
	@Override
	public boolean deleteDept(int deptNo)throws Exception  {
		// 부서 삭제
		return deptDao.deleteDept(deptNo) > 0;
	}
	
}










