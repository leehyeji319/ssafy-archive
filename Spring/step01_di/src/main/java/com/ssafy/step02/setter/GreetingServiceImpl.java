package com.ssafy.step02.setter;


public class GreetingServiceImpl implements GreetingService {
	
	private OutputService outputter;
	
//	public GreetingServiceImpl(OutputService outputter) {
//		super();
//		this.outputter = outputter;
//	}
	
	public void setOutputter(OutputService outputter) {
		this.outputter = outputter;
	}

	@Override
	public void sayHello(String name) {
		outputter.output("Hello" + name);
		
	}

	

	
}
