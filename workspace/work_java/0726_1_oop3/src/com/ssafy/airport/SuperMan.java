package com.ssafy.airport;

public class SuperMan implements Flyer {

	@Override
	public void takeOff() {
		System.out.println("슈퍼맨이 이륙합니다.");
	}

	@Override
	public void flying() {
		System.out.println("슈퍼맨이 비행합니다.");

	}

	@Override
	public void landing() {
		System.out.println("슈퍼맨이 착륙합니다.");

	}

}
