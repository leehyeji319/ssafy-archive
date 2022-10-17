package com.ssafy.hello.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	
	public static void main(String[] args) {
		/**
		 * 아까 만들었던 HelloMessageFacotry를 스프링이 하게 해볼게
		 */
		System.out.println("프로그램 시작 !!! !");
		
		//3.2부터는 context사용 -> 실행되고 있는 메모리영역에 잇는거 
		//사용하려면 Context jar파일 가져와야함
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/ssafy/hello/di4/applicationContext.xml");
		System.out.println("xml읽기 끝 !!");
		HelloMessage hello = (HelloMessage) context.getBean("eng"); //리턴타입이 object임
		String greet = hello.hello("안효인");
		System.out.println(greet);
		
		HelloMessage hello2 = (HelloMessage) context.getBean("eng");
		HelloMessage hello3 = (HelloMessage) context.getBean("eng");
		System.out.println(hello + " " + hello2 + " " + hello3);
		
		
		/**
		 * 객체 두개를 그냥 만들어버리네,,? 우린 가져다 쓰기만 하면 된다.
		 */
	}

}
