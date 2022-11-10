package com.ssafy.myhome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.myhome.model.dto.DataInfoDto;
import com.ssafy.myhome.model.dto.DongCommercialArea;
import com.ssafy.myhome.model.dto.InterestAreaDto;
import com.ssafy.myhome.model.service.InterestAreaService;
import com.ssafy.myhome.model.service.impl.InterestAreaServiceImpl;

public class InterestAreaController implements Controller {

	InterestAreaService interestAreaService = new InterestAreaServiceImpl();

	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if (url.equals("/interest/list.do")) {
			return getinterestAreaList(request, response);
		} else if (url.equals("/interest/register.do")) {
			return registerInterestArea(request, response);
		} else if (url.equals("/interest/setMain.do")) {
			return updateMainInterestAreas(request, response);
		} else if (url.equals("/interest/delete.do")) {
			return deleteInterestArea(request, response);
		} else if (url.equals("/interest/commercial.do")) {
			return getCommercialLabel(request, response);
		}
		
		return null;
	}
	


	private Object getinterestAreaList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getSession().getAttribute("userid").toString();
//		String userId = (String) request.getAttribute("userid");
		List<InterestAreaDto> interestAreaList = interestAreaService.selectInterestAreas(userId);
		
		return new DataInfoDto("application/json", interestAreaList);
		
	}

	
	private Object registerInterestArea(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getSession().getAttribute("userid").toString();
		String dongCode = request.getParameter("dongcode");
		
		boolean success = interestAreaService.insertUserInterestAreaMapping(userId, dongCode);
		request.setAttribute("success", success);
		
		return new DataInfoDto("application/json", success);
		
	}

	private Object updateMainInterestAreas(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getSession().getAttribute("userid").toString();
		String dongCode = request.getParameter("dongcode");
		
		boolean success = interestAreaService.updateUserInteresetAreaMapping(userId, dongCode);
		request.setAttribute("success", success);
		
		return new DataInfoDto("application/json", success);
		
	}
	
	private Object deleteInterestArea(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getSession().getAttribute("userid").toString();
		String dongCode = request.getParameter("dongcode");
		
		boolean success = interestAreaService.deleteUserInterestAreaMapping(userId, dongCode);
		request.setAttribute("success", success);
		
		return new DataInfoDto("application/json", success);
		
	}
	
	private Object getCommercialLabel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String dongCode = request.getParameter("dongcode");
		
		DongCommercialArea dongCommercialLabel = interestAreaService.getCommercialLabel(dongCode);
		
		return new DataInfoDto("application/json", dongCommercialLabel);
		
	}

}
