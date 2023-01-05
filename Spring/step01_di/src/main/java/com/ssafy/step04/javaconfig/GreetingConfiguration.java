package com.ssafy.step04.javaconfig;

import org.springframework.context.annotation.Bean;

//이놈이 xml대신하는 애같은거다
public class GreetingConfiguration {
	
	@Bean
	public GreetingService greeting() {
		GreetingServiceImpl g = new GreetingServiceImpl();
		g.setOutputter(outputter());
		return g;
	}
	
	@Bean //얘가 리턴하는 이 객체를 Bean으로 등록해주세요~(생성은 내가했고)
	public OutputService outputter() {
		return new OutputServiceImplConsole();
	}

}
