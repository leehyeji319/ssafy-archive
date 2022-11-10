package com.ssafy.myhome.model.dto;

import com.ssafy.myhome.model.vo.StoreTypeValue;

public class DongCommercialArea {
	
	String dongCode;
	String dongName;
	
	int convenienceStore;
	int education;
	int cafe;
	int restaurant;
	int health;
	int market;
	
	StoreTypeValue avgDiff;
	StoreTypeValue totalAvg;
	
	Label label;

	public DongCommercialArea(String dongCode, String dongName, int convenienceStore, int education, int cafe,
			int restaurant, int health, int market, StoreTypeValue avgDiff, StoreTypeValue totalAvg, Label label) {
		super();
		this.dongCode = dongCode;
		this.dongName = dongName;
		this.convenienceStore = convenienceStore;
		this.education = education;
		this.cafe = cafe;
		this.restaurant = restaurant;
		this.health = health;
		this.market = market;
		this.avgDiff = avgDiff;
		this.totalAvg = totalAvg;
		this.label = label;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public int getConvenienceStore() {
		return convenienceStore;
	}

	public void setConvenienceStore(int convenienceStore) {
		this.convenienceStore = convenienceStore;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public int getCafe() {
		return cafe;
	}

	public void setCafe(int cafe) {
		this.cafe = cafe;
	}

	public int getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(int restaurant) {
		this.restaurant = restaurant;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMarket() {
		return market;
	}

	public void setMarket(int market) {
		this.market = market;
	}

	public StoreTypeValue getAvgDiff() {
		return avgDiff;
	}

	public void setAvgDiff(StoreTypeValue avgDiff) {
		this.avgDiff = avgDiff;
	}

	public StoreTypeValue getTotalAvg() {
		return totalAvg;
	}

	public void setTotalAvg(StoreTypeValue totalAvg) {
		this.totalAvg = totalAvg;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
	
}
