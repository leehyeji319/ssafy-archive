package com.ssafy.hello.di1;

public class HelloMain {
	
	public static void main(String[] args) {
		
		/**
		 * 객체의 강한 결함 - 어느 한쪽이 바뀌면 다른 한쪽도 바껴야한다.
		 * 해결법 - 다형성을 이용
		 */
		
//		HelloMessageKor kor = new HelloMessageKor();
//		String greet = kor.helloKor("안효인");
		HelloMessageEng kor = new HelloMessageEng();
		String greet = kor.helloEng("안효인");
		System.out.println(greet);
	}

}
