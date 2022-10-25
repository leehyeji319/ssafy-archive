package com.ssafy.step03.annotation;

import org.springframework.stereotype.Component;

@Component("outputter")
public class OutputServiceImplConsole implements OutputService {


	@Override
	public void output(String name) {
		System.out.println(name);
		
	}

}
