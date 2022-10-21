package com.ssafy.empapp.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.empapp.model.dto.Dept;

@Mapper
public interface DeptDAO {

	int insertDept(Dept dept);

	List<Dept> selectDepts();

	Dept selectDept(int deptno);

	int deleteDept(int deptno);

	int updateDept(Dept dept);

}