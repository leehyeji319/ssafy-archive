package com.ssafy.lambda;

public class FunctionalInterfaceTest {
	
	
	@FunctionalInterface //딱하나의 추상 메서드를 가질거면 이렇게 명시해주는게 좋음 //default method는 상관 없
	static interface CalcAble{
		int process(int a, int b);
	}
	
	static int run(CalcAble c) {
		//~~ 
		//처리 결과 10, 20
		//작업 이 달라지는 놈을 내가결정하지 않고 넘긴다
		return c.process(10, 20);
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(run(new CalcAble() {
			
			@Override
			public int process(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		}));
		
		System.out.println(run((a,b) -> a-b));
		System.out.println(run((a, b) -> a*b));
	}
}
