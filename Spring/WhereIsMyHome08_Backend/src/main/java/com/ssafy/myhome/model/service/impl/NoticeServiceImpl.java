package com.ssafy.myhome.model.service.impl;

import java.util.List;

import com.ssafy.myhome.model.dao.impl.NoticeDaoImpl;
import com.ssafy.myhome.model.dto.NoticeDto;
import com.ssafy.myhome.model.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	
	private static NoticeServiceImpl instance;
	
	private NoticeServiceImpl() {}
	
	public static NoticeServiceImpl getInstance() {
		if (instance == null) {
			instance = new NoticeServiceImpl();
		}
		return instance;
	}
	@Override
	public boolean registerNotice(String title, String content) throws Exception {
		
		return NoticeDaoImpl.getInstance().registerNotice(title, content) > 0;
	}

	@Override
	public List<NoticeDto> getNoticeList() throws Exception {
		return NoticeDaoImpl.getInstance().getNoticeList();
	}

	@Override
	public NoticeDto getNotice(String noticeId) throws Exception {
		return NoticeDaoImpl.getInstance().getNotice(noticeId);
	}

	@Override
	public boolean updateNotice(String noticeId, String title, String content) throws Exception {
		return NoticeDaoImpl.getInstance().updateNotice(noticeId, title, content) > 0;
	}

	@Override
	public boolean deleteNotice(String noticeId) throws Exception {
		return NoticeDaoImpl.getInstance().deleteNotice(noticeId) > 0;
	}

}
