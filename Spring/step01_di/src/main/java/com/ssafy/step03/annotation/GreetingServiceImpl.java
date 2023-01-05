package com.ssafy.step03.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("greeting") //이렇게 붙이면 된다. 이름은 컴포넌트에 붙여줘~ value String 혹은 바로 String
public class GreetingServiceImpl implements GreetingService {
	
	//setter에 안붙이고 private변수에 붙엿어요. 이렇게도 가능합니다. private인데 어케 접근해요? reflection api으로 처리하는거에요
	//annotation -> 멤버변수에도 붙일 수 있다.
//	@Qualifier("outputterFile") //동일한 빈이 한개든 두개든 세개든 무조건 이거랑 맞아야됨. 한정사를 준거임!!
//	@Autowired 
	private OutputService outputter;


	@Autowired //생성자에에도 Autowired가능하다
	public GreetingServiceImpl(OutputService outputter) {
		super();
		this.outputter = outputter;
	}
	
	/*
	 * @Autowired 매개변수로 오는 놈의 타입! -> OutputService타입만 받을수잇겟죠.
	 * 내가 생성한 애들중에 OutputService Type이 잇는지 찾아본다. 누가우선? 이름이 똑같은애부터 만약 없다면? 퀄리파이같은 한정사 사용해도 좋다.
	 * */
//	@Qualifier("outputterFile") //동일한 빈이 한개든 두개든 세개든 무조건 이거랑 맞아야됨. 한정사를 준거임!!
//	@Autowired 
	public void setOutputter(OutputService outputter) {
		//타입도 OutputService이거니와, 이름도 완전히 똑같아야함
		this.outputter = outputter;
	} //property는 세터메서드로 하는것이기 때문에 만약 이걸 주석처리한다?? 그럼 property name 절대 안나온다.
	//mybatis는  

	@Override
	public void sayHello(String name) {
		outputter.output("Hello" + name);
		
	}

	

	
}
