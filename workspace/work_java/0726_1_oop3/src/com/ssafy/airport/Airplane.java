package com.ssafy.airport;

public class Airplane implements Flyer {

	@Override
	public void takeOff() {
		System.out.println("비행기가 이륙합니다.");
	}

	@Override
	public void flying() {
		System.out.println("비행기가 비행합니다.");
		
	}

	@Override
	public void landing() {
		System.out.println("비행기가 착륙합니다.");
		
	}
	
}
