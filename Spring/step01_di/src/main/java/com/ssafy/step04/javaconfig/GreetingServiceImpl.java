package com.ssafy.step04.javaconfig;

public class GreetingServiceImpl implements GreetingService {
	

	private OutputService outputter;

	public void setOutputter(OutputService outputter) {
		this.outputter = outputter;
	} 

	@Override
	public void sayHello(String name) {
		outputter.output("Hello" + name);
		
	}


	
}
