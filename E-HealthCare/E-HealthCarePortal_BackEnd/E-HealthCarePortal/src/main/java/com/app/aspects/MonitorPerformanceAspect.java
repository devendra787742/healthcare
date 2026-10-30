package com.app.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//AOP - Aspect-Oriented Programming

@Aspect 		//class contains cross cutting concerns
@Component	
@Slf4j
public class MonitorPerformanceAspect {

	@Around("execution(* com.app.controller.*.*(..))")
	public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable{

		log.info("Begins monitoring ");		
		long begin=System.currentTimeMillis();
		log.info("Proceeding to req handling method");
		Object ret = joinPoint.proceed();				
		log.info("Time taken by method : {} in  {} msec",joinPoint.getSignature(),System.currentTimeMillis()-begin);		
		return ret;		
	}
}