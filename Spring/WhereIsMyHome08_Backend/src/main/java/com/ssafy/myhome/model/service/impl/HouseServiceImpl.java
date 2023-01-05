package com.ssafy.myhome.model.service.impl;

import java.util.List;

import com.ssafy.myhome.model.dao.HouseDao;
import com.ssafy.myhome.model.dao.impl.HouseDaoImpl;
import com.ssafy.myhome.model.dto.HouseDealDto;
import com.ssafy.myhome.model.dto.HouseInfoDto;
import com.ssafy.myhome.model.service.HouseService;

public class HouseServiceImpl implements HouseService{

	private HouseDao houseDao = HouseDaoImpl.getInstance();
	
	public List<HouseInfoDto> getHouseList(String dongcode) throws Exception {
		// 아파트 거래 리스트 조회
		return houseDao.selectHouseList(dongcode);
	}

	@Override
	public List<HouseDealDto> getHouseDeals(int aptcode) throws Exception {
		// 아파트 상세 거래 리스트 조회
		return houseDao.selectHouseDeals(aptcode);
	}
}
