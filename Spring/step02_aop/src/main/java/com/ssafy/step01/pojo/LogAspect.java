package com.ssafy.step01.pojo;

import org.aspectj.lang.JoinPoint;

public class LogAspect {

	//어느 메서드가 호출되는지 알아보려고 매개변수 ㅋㅋ
	public void beforeLogging(JoinPoint joinPoint) {
		//target의 joinPoint로 알아낼 수 있음.. 매개변수 등
		System.out.println("메소드 호출 전.." + joinPoint.getSignature().getName() + "," + joinPoint.getArgs()[0]);
		/*
		 * jointPoint.getSignature():뭐가 불리는지
		 * joinPoint.getSignature().getName(): 메서드 이름까지 확인
		 * joinPoint.getArgs(): 매개변수를 꺼내볼수있따.
		 * */
	}
}
