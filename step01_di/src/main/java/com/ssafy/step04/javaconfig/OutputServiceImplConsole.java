package com.ssafy.step04.javaconfig;

import org.springframework.stereotype.Component;

public class OutputServiceImplConsole implements OutputService {


	@Override
	public void output(String name) {
		System.out.println(name);
		
	}

}
