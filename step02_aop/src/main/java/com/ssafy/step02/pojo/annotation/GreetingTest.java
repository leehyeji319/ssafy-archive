package com.ssafy.step02.pojo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		GreetingService bean = context.getBean("greeting", GreetingService.class);
		
		System.out.println(bean.getClass().getName()); //reflection api
		bean.sayHello("김재환");
		System.out.println("==============================");
		bean.sayGoodbye("김재ghks");
	}

}
