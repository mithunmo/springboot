package com.f9g4.common.util;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
 
@Aspect
public class BONullAspect
{
	@Pointcut("within(com.f4g.businessobjects.*) && execution(* get*(..))")
	public void handleNull() 
	{
	}
		
	@Around("handleNull()")
	public Object returnNonNull(ProceedingJoinPoint pjp) throws Throwable 
	{
		// 1. Execute the get method.
		Object output = pjp.proceed();
		
		// 2. Create a new object if the return type is null
		if (output == null)
		{
			Object proxy = pjp.getTarget();
			Method realMethod = proxy.getClass().getMethod(pjp.getSignature().getName());
			return realMethod.getReturnType().newInstance();
		}
		else
			return output;
	}
}