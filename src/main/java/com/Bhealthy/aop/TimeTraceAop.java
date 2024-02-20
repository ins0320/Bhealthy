package com.Bhealthy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component // spring bean 으로 등록, singleton(전체에 이 객체가 하나만 존재함)
@Aspect // 부가기능정의(advice) + 어디에 적용 ( pointcut)
public class TimeTraceAop {

//	// 1) 수행할 패키지 지정
//	@Around("execution(* com.Bhealthy..*(*))")
	
	// 2) 어노테이션 지정
	@Around("@annotation(TimeTrace)")
	
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		// 타겟이 적용하는 메소드 - joinPoint ( 시간 측정이 적용)
		
		// 시간 측정
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// 본래 할 일 수행 ( 예: 회원가입, 로그인, 글쓰기 등..) - joinPoint
		Object proceedObj = joinPoint.proceed();
		
		stopWatch.stop();
		log.info("#### 실행시간(ms): {}", stopWatch.getTotalTimeMillis());
		log.info("@@@@@ 실행시간" +  stopWatch.prettyPrint());
		
		return proceedObj;		
	}
}
