package com.ssafy.empapp.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.EmpDAO;
import com.ssafy.empapp.model.dto.Emp;

@Service
public class EmpServiceImpl implements EmpService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmpDAO empDao;
	

	@Override
	public boolean insertEmp(Emp emp) {
		logger.info("사원 정보 등록");
		return empDao.insertEmp(emp) > 0;
	}

	@Override
	public List<Emp> selectEmps() {
		return empDao.selectEmps();
	}

	@Override
	public Emp selectEmp(int empno) {
		return empDao.selectEmp(empno);
	}

	@Override
	public boolean updateEmp(Emp emp) {
		return empDao.updateEmp(emp) > 0;
	}

	@Override
	public boolean deleteEmp(int empno) {
		return empDao.deleteEmp(empno) > 0;
	}
	
//	@Override
//	public void deleteEmps(int[] empNos) {
//		HashMap<String,Object> map = new HashMap<String,Object>();
//		map.put("array", empNos);
//		empDao.deleteEmps(map);
//	}
	//체크박스로 삭제
	@Override
	public void deleteEmps(int[] empNos) {
		empDao.deleteEmps(empNos);
	}


}













