package com.ssafy.step04.javaconfig2;

import org.springframework.context.annotation.Bean;

public class GreetingConfiguration2 {
	
	@Bean //얘가 리턴하는 이 객체를 Bean으로 등록해주세요~(생성은 내가했고)
	public OutputService outputter() {
		return new OutputServiceImplConsole();
	}

}
