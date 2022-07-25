package com.ssafy.live3.abs;

public abstract class Vehicle {
	private int curX, curY;
		
    public void reportPosition() {
        System.out.printf("차종: %s: 현재 위치: (%d, %d)%n", this.getClass().getSimpleName(), curX, curY);
      }
	
//	public void addFuel() {
//	    System.out.printf("운송수단은 연료가 필요하지.");
//		}
    
    //객체를 생성할 수 없는 클래스라는 의미로 abstract추가
    public abstract void addFuel();
}
