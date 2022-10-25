package com.ssafy.empapp.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper //spring scanner가 mapper붙은 애들만 하기로 햇잖아요
public interface EmpDAO {
	
//	void deleteEmps(Map<String, Object> map);
	void deleteEmps(int[] empNos);

}
