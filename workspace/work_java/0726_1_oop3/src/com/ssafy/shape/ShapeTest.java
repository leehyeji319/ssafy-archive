package com.ssafy.shape;

import com.shape.ShapeCalculator;

public class ShapeTest {

	public static void main(String[] args) {
		
		Circle c = new Circle(2.0);
		//new Shape();//추상클래스 객체생성 안된다.
		//Shape s; //하지만 이렇게 타입으로 쓰는건 괜찮음
		ShapeCalculator util = new ShapeCalculator();
		util.calcArea(c);
	}

}
