package com.ssafy.myhome.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myhome.model.dto.NoticeDto;

public interface NoticeService {
	boolean registerNotice (String title, String content) throws Exception;
	
	List<NoticeDto> getNoticeList() throws Exception;
	
	NoticeDto getNotice(String noticeId) throws Exception;
	
	boolean updateNotice(String noticeId, String title, String content) throws Exception;
	
	boolean deleteNotice(String noticeId) throws Exception;
}
