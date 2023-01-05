package com.ssafy.myhome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.myhome.model.dto.DataInfoDto;
import com.ssafy.myhome.model.dto.HouseDealDto;
import com.ssafy.myhome.model.dto.HouseInfoDto;
import com.ssafy.myhome.model.dto.PageInfoDto;
import com.ssafy.myhome.model.service.impl.HouseServiceImpl;

public class HouseController implements Controller{

	HouseServiceImpl houseService = new HouseServiceImpl();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = request.getServletPath();
		
		if (url.equals("/house/list.do")) {
			return getHouseList(request, response);
		} else if (url.equals("/house/rest/deals.do")) {
			return getHouseDeals(request, response);
		} else {
			return null;
			
		}
		
	}

	private Object getHouseDeals(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String temp = request.getParameter("aptcode");
		int aptCode = Integer.parseInt(temp);
		List<HouseDealDto> houseDeals = houseService.getHouseDeals(aptCode);
		
		return new DataInfoDto("application/json", houseDeals);
	}

	private Object getHouseList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dongcode = request.getParameter("dongcode");
		
		List<HouseInfoDto> houseList = houseService.getHouseList(dongcode);
	
		return new DataInfoDto("application/json", houseList);
	}

}
