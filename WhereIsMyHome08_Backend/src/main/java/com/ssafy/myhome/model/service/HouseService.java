package com.ssafy.myhome.model.service;

import java.util.List;

import com.ssafy.myhome.model.dto.HouseDealDto;
import com.ssafy.myhome.model.dto.HouseInfoDto;

public interface HouseService {
	public List<HouseInfoDto> getHouseList(String dongcode) throws Exception;
	
	public List<HouseDealDto> getHouseDeals(int aptcode) throws Exception;
}
