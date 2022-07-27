package com.ssafy.lambda;

public class BasicTest {

	public static void main(String[] args) {
		
		//자바는 메소드를 주고싶으면 메소드를 가지고 있는 객체를 줘야한다. 그냥 메서드만 못 줌!
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread1....");
			}
		}).start(); //일꾼을 하나 만듬 
		
		new Thread (() -> {
			System.out.println("Thread2...");
		}).start();
		
		new Thread(() -> System.out.println("Thread4....")).start();
		new Thread(new MyRunnable()).start();
	}

}
