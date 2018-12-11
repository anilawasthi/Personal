package com.jp.hr.advises;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect //Means this code should not advice itself
public class SecurityCheck {
	// 2 dots in belo code means any number of parameters the method may hava and it will call it
	//MyServices.* means it can have anynumber of class, it will still call
	//If we have to call a method which has just two parameters then we need to write the line like below
	// @Around("execution(* com.jp.hr.services.MyServices.*(*,*))")
	//If we have to call a method which has "3" at the end of the method name then we need to write the line like below
	// @Around("execution(* com.jp.hr.services.MyServices.*3(*,*))")
	
	@Around("execution(* com.jp.hr.services.MyServices.*(..))")
	public Object checkAuthorization(ProceedingJoinPoint doCall) throws Throwable{
		System.out.println("Check for authorization");
		Object obj = doCall.proceed();
		System.out.println("Logging");
		return obj;
	}
	
}
