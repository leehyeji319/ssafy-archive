package com.ssafy.myhome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.myhome.model.dto.HouseInfoDto;
import com.ssafy.myhome.model.dto.PageInfoDto;
import com.ssafy.myhome.service.HouseService;

public class HouseController implements Controller{

	HouseService houseService = new HouseService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = request.getServletPath();
		
		if (url.equals("/house/list.do")) {
			return getHouseList(request, response);
		} else {
			return null;
			
		}
		
	}

	private Object getHouseList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dongcode = request.getParameter("dongcode");
		
		List<HouseInfoDto> houseList = houseService.getHouseList(dongcode);
		request.setAttribute("houseList", houseList);
		System.out.println(houseList);
		return new PageInfoDto(true, "/house/list.jsp");
	}

}
