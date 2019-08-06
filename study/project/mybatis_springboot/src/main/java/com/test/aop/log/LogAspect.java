package com.test.aop.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Repository;

@Repository
@Aspect
public class LogAspect implements Ordered {

	private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Pointcut(value = "execution(public * com.test.aop.service..*(..))")
	public void pointcutA() {

	}

	@Pointcut(value = "within(com.test.aop..*)")
	public void pointcutB() {

	}

	@Before("pointcutA()")
	public void beforeA() {
		logger.debug("debug pointcutA beforeA method log......");
		logger.info("pointcutA beforeA method log......");
	}

	@Around("pointcutA()")
	public void aroundA(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("pointcutA aroundA start method log......");
		
		joinPoint.proceed();
		
		logger.info("pointcutA aroundA end method log......");
	}

	@AfterReturning(value = "pointcutA()", returning = "returnVal")
	public void afterReturningA(Object returnVal) {
		logger.info("pointcutA afterReturningA method log......");

		System.out.println("returnVal:" + returnVal);
	}

	@After(value = "pointcutA()")
	public void afterA() {
		logger.info("pointcutA after method log......");
	}

	@Pointcut("execution(* com.test.aop.service..*.*(String, int)) && args(param1, param2)")
	public void pointcutC(String param1, int param2) {
		
	}
	
	@Before("pointcutC(param1, param2)")
	public void beforeC(String param1, int param2) {
		logger.info("pointcutC before method log......" + param1 + " " + param2);
	}
	
	@Override
	public int getOrder() {
		return 0;
	}
}
