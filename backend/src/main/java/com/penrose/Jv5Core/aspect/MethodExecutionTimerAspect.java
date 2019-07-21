package com.penrose.Jv5Core.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecutionTimerAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodExecutionTimerAspect.class);
	
	@Around("com.penrose.Jv5Core.aspect.CommonJoinPointConfig.allLayerExecution()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		 long startTime = System.currentTimeMillis();
		 LOGGER.info("** START {}", proceedingJoinPoint.getSignature().toShortString());
		 
		 Object result = proceedingJoinPoint.proceed();
		 
		 long elapsedTime = System.currentTimeMillis() - startTime;
		 
		 LOGGER.info("** END {}, took {} ms", proceedingJoinPoint.getSignature().toShortString(),elapsedTime);
		 
		 return result; 
	}
}
