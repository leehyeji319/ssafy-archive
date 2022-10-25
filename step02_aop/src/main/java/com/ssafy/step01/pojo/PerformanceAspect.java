package com.ssafy.step01.pojo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {
	
	//이 공통 메서드 하나가 타겟 호출 전, 호출 후, 예외를 던졌을 때 등 식별이 될 수 있게끔 해야함 - 그래서 매개변수로 ProceedingJoinPoint를 가져와서 확인할 수잇다
	public Object timeCheck(ProceedingJoinPoint joinPoint) {
		
		Signature s = joinPoint.getSignature();
		System.out.println("\t" + s.getName() + "'s time checking start...");
		long start = System.nanoTime();
		Object o = null; //리턴값하나 만들기
		try {
			//이 호출 코드 전이 타겟실행 전인 before
			joinPoint.proceed();
			//이 호출 코드 후가 타겟 실행 후인 after
			// throw 등등 ...
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		System.out.println(s.getName() + "'s processing time is " + (end - start) + "ms");
		
		return o;
	}
}
