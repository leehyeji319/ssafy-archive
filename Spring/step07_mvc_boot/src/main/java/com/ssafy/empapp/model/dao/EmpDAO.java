package com.ssafy.empapp.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDAO {

//	void deleteEmps(Map<String,Object> map);
	void deleteEmps(int[] empNos);
}
