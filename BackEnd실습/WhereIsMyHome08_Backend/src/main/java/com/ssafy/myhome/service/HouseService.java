package com.ssafy.myhome.service;

import java.util.List;

import com.ssafy.myhome.model.dao.HouseDao;
import com.ssafy.myhome.model.dao.impl.HouseDaoImpl;
import com.ssafy.myhome.model.dto.HouseInfoDto;

public class HouseService {

	private HouseDao houseDao = HouseDaoImpl.getInstance();
	
	public List<HouseInfoDto> getHouseList(String dongcode) throws Exception {
		// 아파트 리스트 조회
		return houseDao.selectHouseList(dongcode);
	}
}
