package com.ssafy.step01.pojo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
		GreetingService bean = context.getBean("greeting", GreetingService.class);
		
		bean.sayHello("김재환");
	}

}
