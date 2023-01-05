package com.ssafy.myhome.model.dto;

public class Label {
	
	String labelId;
	String name;
	
	public Label(String labelId, String name) {
		this.labelId = labelId;
		this.name = name;
	}

	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
