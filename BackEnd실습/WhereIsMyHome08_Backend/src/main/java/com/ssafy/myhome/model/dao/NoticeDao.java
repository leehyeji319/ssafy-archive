package com.ssafy.myhome.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myhome.model.dto.NoticeDto;
import com.ssafy.myhome.model.dto.UserDto;

public interface NoticeDao {
	
	int registerNotice (String title, String content) throws SQLException;
	
	List<NoticeDto> getNoticeList() throws SQLException;
	
	NoticeDto getNotice(String noticeId) throws SQLException;
	
	int updateNotice(String noticeId, String title, String content) throws SQLException;
	
	int deleteNotice(String noticeId) throws SQLException;
}
