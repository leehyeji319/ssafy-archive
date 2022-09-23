package com.ssafy.myhome.model.dto;

public class PageInfoDto {
	
	private boolean forward;
	private String page;
	
	

	public PageInfoDto(boolean forward, String page) {
		super();
		this.forward = forward;
		this.page = page;
	}

	public boolean isForward() {
		return forward;
	}

	public void setForward(boolean forward) {
		this.forward = forward;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
}
