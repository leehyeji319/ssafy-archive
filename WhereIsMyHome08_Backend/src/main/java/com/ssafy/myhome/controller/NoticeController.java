package com.ssafy.myhome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.myhome.model.dto.DataInfoDto;
import com.ssafy.myhome.model.dto.NoticeDto;
import com.ssafy.myhome.model.dto.PageInfoDto;
import com.ssafy.myhome.model.service.impl.NoticeServiceImpl;

public class NoticeController implements Controller {

	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if (url.equals("/notice/notice.do")) {
			return getNoticeList(request, response);
		} else if (url.equals("/notice/notice_detail.do")) {
			return getNotice(request, response);
		} else if (url.equals("/notice/noticeUpdate_form.do")) {
			return updateForm(request, response);
			
		} else if (url.equals("/notice/update.do")) {
			
			return updateNotice(request, response);
			
		} else if (url.equals("/notice/delete.do")) {
			return deleteNotice(request, response);
			
		} else if (url.equals("/notice/register_form.do")) {
			return registerForm(request, response);
		} else if (url.equals("/notice/register.do")) {
			return registerNotice(request, response);
		}
		return null;
	}

	protected PageInfoDto registerNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean isUpdated = NoticeServiceImpl.getInstance().registerNotice(title, content);		
		request.setAttribute("isUpdated", isUpdated);
		return new PageInfoDto(false, "/notice/notice.do");
	}
	
	protected PageInfoDto getNoticeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<NoticeDto> notices = NoticeServiceImpl.getInstance().getNoticeList();
		request.setAttribute("notices", notices);
		return new PageInfoDto(true, "/notice/notice.jsp");
	}
	protected PageInfoDto getNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeid");
		NoticeDto notice = NoticeServiceImpl.getInstance().getNotice(noticeId);
		
		request.setAttribute("notice", notice);
		
		return new PageInfoDto(true, "/notice/detail.jsp");
	}
	
	protected DataInfoDto updateNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
//		System.out.println(noticeId);
//		System.out.println(title);
//		System.out.println(content);
		
		boolean isUpdated = NoticeServiceImpl.getInstance().updateNotice(noticeId, title,content);		
		request.setAttribute("isUpdated", isUpdated);
		
		
		return new DataInfoDto("application/json", isUpdated);
	}
	
	protected DataInfoDto deleteNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeId");
		System.out.println(noticeId);

		boolean isDeleted = NoticeServiceImpl.getInstance().deleteNotice(noticeId);		
		request.setAttribute("isDeleted", isDeleted);
		
		
		return new DataInfoDto("application/json", isDeleted);
	}
	
	private Object registerForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return new PageInfoDto(false, "/notice/register.jsp");
	}

	private Object updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String noticeId = request.getParameter("noticeid");
		NoticeDto notice = NoticeServiceImpl.getInstance().getNotice(noticeId);
//		System.out.println(noticeId);
//		System.out.println(notice.toString());
		request.setAttribute("notice", notice);
		return new PageInfoDto(true, "/notice/update.jsp");
	}
	
	private Object detail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return new PageInfoDto(false, "/notice/detail.jsp");
		
	}


}
