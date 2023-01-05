package com.ssafy.myhome.model.service.impl;

import java.util.ArrayList;

import com.ssafy.myhome.model.dao.InterestAreaDao;
import com.ssafy.myhome.model.dao.impl.InterestAreaDaoImpl;
import com.ssafy.myhome.model.dto.DongCommercialArea;
import com.ssafy.myhome.model.dto.InterestAreaDto;
import com.ssafy.myhome.model.service.InterestAreaService;

public class InterestAreaServiceImpl implements InterestAreaService {
	
	private InterestAreaDao interestAreaDao = InterestAreaDaoImpl.getInstance();

	@Override
	public boolean insertUserInterestAreaMapping(String userId, String dongCode) throws Exception {
		return interestAreaDao.insertUserInterestAreaMapping(userId, dongCode) > 0;
	}

	@Override
	public ArrayList<InterestAreaDto> selectInterestAreas(String userId) throws Exception {
		return interestAreaDao.selectInterestAreas(userId);
	}

	@Override
	public boolean updateUserInteresetAreaMapping(String userId, String dongCode) throws Exception {
		return interestAreaDao.updateUserInteresetAreaMapping(userId, dongCode) > 0;
	}

	@Override
	public boolean deleteUserInterestAreaMapping(String userId, String dongCode) throws Exception {
		return interestAreaDao.deleteUserInterestAreaMapping(userId, dongCode) > 0;
	}

	@Override
	public DongCommercialArea getCommercialLabel(String dongCode) throws Exception {
		return interestAreaDao.getCommercialLabel(dongCode);
	}

}
