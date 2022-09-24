package com.ssafy.myhome.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myhome.model.dto.HouseDealDto;
import com.ssafy.myhome.model.dto.HouseInfoDto;

public interface HouseDao {

	List<HouseInfoDto> selectHouseList(String dongcode) throws SQLException;

	List<HouseDealDto> selectHouseDeals(int aptcode) throws SQLException;

}
