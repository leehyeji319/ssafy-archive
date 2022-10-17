package com.ssafy.hello.di3;

public class HelloMain {
	
	public static void main(String[] args) {
		/**
		 * 팩토리 생성
		 * 객체를 생성하는 애가 외부로 바뀐다(Assembler)
		 * Spring을 이용하면 Factory + Singleton 까지 된다.
		 */
		//일종의 싱글톤으로 변경
		HelloMessage hello = HelloMessageFacotry.getHelloMessage("eng");
		String greet = hello.hello("안효인");
		System.out.println(greet);
	}

}
