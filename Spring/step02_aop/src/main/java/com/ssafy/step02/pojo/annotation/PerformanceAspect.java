package com.ssafy.step02.pojo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Aspect
@Component
public class PerformanceAspect {
	
	@Around("execution(* *(..))") //포인트컷 재사용 안했을 
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
