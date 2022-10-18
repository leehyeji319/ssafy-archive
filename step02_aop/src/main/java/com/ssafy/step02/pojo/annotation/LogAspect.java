package com.ssafy.step02.pojo.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect //똥인지 된장인지 알려줘야하니까.. 이객체가 공통로직으로 등록이되어야한다는걸 알려주는거고
@Component //객체가 되어야한다는걸 알려주는거고 
public class LogAspect {
	
	//구현내용은 1도관심없다, 재사용할때!!!!!!!!!!!!!!!!
	@Pointcut("execution(void com.ssafy..GreetingService.*Hello(*))")
	public void sayPointcut() {	}

	//포인트컷 재사용 안될 때
	@Before("sayPointcut()") //빨간줄 뜬다.타겟이 될 pointcut을 알려줘야함 Before(value="") <- value에 포인트컷
	public void beforeLogging(JoinPoint joinPoint) {
		System.out.println("메소드 호출 전.." + joinPoint.getSignature().getName() + "," + joinPoint.getArgs()[0]);

	}
}
