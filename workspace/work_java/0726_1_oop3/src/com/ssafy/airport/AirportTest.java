package com.ssafy.airport;

public class AirportTest {

	public static void main(String[] args) {
		
		Airport.giveToTakeOffPermission(new SuperMan()); // Flyer f = new SuperMan() 하위타읍을 상위 클래스에 담았다. 
		Airport.giveToTakeOffPermission(new Airplane());

	}
//CPlane Airplane 세일링 플라이어 오브젝트
}
