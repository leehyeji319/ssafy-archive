package com.ssafy.empapp.model.service;

import java.util.List;

import com.ssafy.empapp.model.dto.Emp;

public interface EmpService {
	
	boolean insertEmp(Emp emp);
	
	List<Emp> selectEmps();
	
	Emp selectEmp(int empno);
	
	boolean updateEmp(Emp emp);
	
	boolean deleteEmp(int empno);

	void deleteEmps(int[] empNos);


}
