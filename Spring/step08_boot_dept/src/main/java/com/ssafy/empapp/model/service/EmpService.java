package com.ssafy.empapp.model.service;

import java.util.List;

import com.ssafy.empapp.model.dto.Emp;

public interface EmpService {

	void deleteEmps(int[] empNos);
	
	List<Emp> getEmpsByDeptNo(int deptNo);
}