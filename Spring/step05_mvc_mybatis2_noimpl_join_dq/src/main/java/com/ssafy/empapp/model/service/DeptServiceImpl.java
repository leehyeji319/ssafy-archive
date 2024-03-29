package com.ssafy.empapp.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.DeptDAO;
import com.ssafy.empapp.model.dto.Dept;

@Service
// Model : B/L
public class DeptServiceImpl implements DeptService {

	private DeptDAO deptDao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public DeptServiceImpl(DeptDAO deptDao) {
		super();
		this.deptDao = deptDao;
	}
	
	@Override
	public boolean registerDept(Dept dept) {
		// 부서 등록
		return deptDao.insertDept(dept) > 0;
	}
	@Override
	public List<Dept> getDepts(){
		
		System.out.println("부서리스트 조회");
		logger.info("부서리스트 조회");
		
		// 부서리스트 조회
		return deptDao.selectDepts();
	}
	@Override
	public Dept getDept(int deptno){
		// 부서조회
		return deptDao.selectDept(deptno) ;
	}
	@Override
	public boolean modifyDept(Dept dept){
		// 부서 수정
		return deptDao.updateDept(dept) > 0;
	}
	@Override
	public boolean deleteDept(int deptNo)  {
		// 부서 삭제
		return deptDao.deleteDept(deptNo) > 0;
	}

	@Override
	public Dept getDeptWithEmps(int deptno){
		return deptDao.selectDeptWithEmps(deptno);
	}

	@Override
	public List<Dept> searchByDNameAndDLoc(Map<String, String> map) {
		return deptDao.searchByKeywords(map);
	}
	
}










