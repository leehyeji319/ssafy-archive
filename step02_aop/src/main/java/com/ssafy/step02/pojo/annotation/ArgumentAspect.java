package com.ssafy.step02.pojo.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(1)
@Aspect
@Component
public class ArgumentAspect {
	
	@Before("execution(void com.ssafy..GreetingService.*Goodbye(*))")
	public void invalidNameCheck(JoinPoint joinPoint) {
		String nameCheck = (String) joinPoint.getArgs()[0];
		if (nameCheck.length() < 3) {
			throw new IllegalArgumentException();
		}
	}
	
}
