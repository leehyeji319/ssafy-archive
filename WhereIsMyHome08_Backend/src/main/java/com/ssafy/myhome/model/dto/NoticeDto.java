package com.ssafy.myhome.model.dto;

import java.util.Date;

public class NoticeDto {
	
	private int noticeId;
	private String title;
	private String content;
	private String date_time;
	private int hit;
	public NoticeDto(int noticeId, String title, String content, String date_time, int hit) {
		super();
		this.noticeId = noticeId;
		this.title = title;
		this.content = content;
		this.date_time = date_time;
		this.hit = hit;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	@Override
	public String toString() {
		return "NoticeDto [noticeId=" + noticeId + ", title=" + title + ", content=" + content + ", date_time="
				+ date_time + ", hit=" + hit + "]";
	}
	
	
	
	
	
	
}
