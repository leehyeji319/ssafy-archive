package com.ssafy.step04.javaconfig2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


//이놈이 xml대신하는 애같은거다
@Configuration
@Import(GreetingConfiguration2.class) //Configuration이 Configuration을 임포트할수잇다.
public class GreetingConfiguration {
	
//	@Bean
//	public GreetingService greeting() {
//		GreetingServiceImpl g = new GreetingServiceImpl(); //이상태론 주입안되니까 그리팅서비스임플에 오토와이어드잇어야지
//		return g;
//	}
	
	
	//스프링 컨테이너가 얘를 부를때 outputter라는 이름을 가진 애를 넣어준다.
	@Bean
	public GreetingService greeting(OutputService outputter) {
		GreetingServiceImpl g = new GreetingServiceImpl();
		g.setOutputter(outputter);
		return g;
	}
	
}
