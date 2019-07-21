package com.penrose.Jv5Core.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonJoinPointConfig {

	// Domains
	@Pointcut("execution(* com.penrose.Jv5Core.user..*(..))")
	public void userDomainExecution() {}
	
	// Layers
	@Pointcut("execution(* com.penrose.Jv5Core..controller..*(..))")
	public void controllerLayerExecution() {}	

	@Pointcut("execution(* com.penrose.Jv5Core..service..*(..))")
	public void serviceLayerExecution() {}	
	
	@Pointcut("execution(public !void org.springframework.data.repository.Repository+.*(..))")
	public void repositoryLayerExecution() {}	
	
	// Combined Layers
	@Pointcut("controllerLayerExecution() || serviceLayerExecution() || repositoryLayerExecution()")
	public void allLayerExecution() {}		
	
}
