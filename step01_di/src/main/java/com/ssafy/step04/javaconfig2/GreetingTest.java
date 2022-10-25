package com.ssafy.step04.javaconfig2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	
	public static void main(String[] args) {
		//생성하는 애가 바뀌어야한다.
		//오버라이딩한 애가 많은데,, 그런 컨피그레이션이 집합해있는 베이스어쩌구를 해도된다.
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GreetingConfiguration.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.ssafy.step04.javaconfig2");
		GreetingService bean = context.getBean("greeting", GreetingService.class);
		
		bean.sayHello("김재환");
	}

}
