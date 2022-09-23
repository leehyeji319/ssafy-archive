package com.ssafy.myhome.model.dto;

public class CodeDto {
	
	private String sidoCode;
	private String dongCode;
	private String gugunCode;
	
	private String name;

	public CodeDto(String sidoCode, String dongCode, String gugunCode, String name) {
		super();
		this.sidoCode = sidoCode;
		this.dongCode = dongCode;
		this.gugunCode = gugunCode;
		this.name = name;
	}

	public String getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(String gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
