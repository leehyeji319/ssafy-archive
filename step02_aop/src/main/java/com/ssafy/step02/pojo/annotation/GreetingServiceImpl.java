package com.ssafy.step02.pojo.annotation;

import org.springframework.stereotype.Service;

@Service("greeting")
public class GreetingServiceImpl implements GreetingService {
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
		
	}

	@Override
	public void sayGoodbye(String name) {
		// TODO Auto-generated method stub
		System.out.println("Goodbye " + name);
	}

	

	
}
