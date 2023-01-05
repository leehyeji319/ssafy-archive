package com.ssafy.empapp.model.service;

import java.util.List;

import com.ssafy.empapp.model.dto.Dept;

public interface DeptService {

	boolean registerDept(Dept dept) throws Exception;

	List<Dept> getDepts() throws Exception;

	Dept getDept(int deptno) throws Exception;

	boolean modifyDept(Dept dept) throws Exception;

	boolean deleteDept(int deptNo) throws Exception;

}