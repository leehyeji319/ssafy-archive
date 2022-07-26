package com.ssafy.airport;

public class Airport{
	
	//Object o도 쓸 수잇지만 내가 쓰려는 구체적인 기능은 가지고 있지 않다.
	//객체가 생성되지 않아도 되니까 static으로 바꿔준다.
	public static void giveToTakeOffPermission(Flyer f) {
		f.takeOff();
	}
}
