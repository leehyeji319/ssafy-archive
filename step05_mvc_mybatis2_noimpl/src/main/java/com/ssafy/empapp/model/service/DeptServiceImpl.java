package com.ssafy.empapp.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.DeptDAO;
import com.ssafy.empapp.model.dto.Dept;

@Service
public class DeptServiceImpl implements DeptService {

	private DeptDAO deptDao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public DeptServiceImpl(DeptDAO deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public boolean registerDept(Dept dept){
		return deptDao.insertDept(dept) > 0;
	}

	@Override
	public List<Dept> getDepts(){
		System.out.println("부서 목록 조회");
        logger.info("부서 목록 조회");
		return deptDao.selectDepts();
	}

	@Override
	public Dept getDept(int deptno){
		return deptDao.selectDept(deptno);
	}

	@Override
	public boolean deleteDept(int deptno){
		return deptDao.deleteDept(deptno) > 0;
	}

	@Override
	public boolean modifyDept(Dept dept) {
		return deptDao.updateDept(dept) > 0;
	}

	@Override
	public Dept getDeptWithEmps(int deptno) {
		return deptDao.selectDeptWithEmps(deptno);
	}
}
