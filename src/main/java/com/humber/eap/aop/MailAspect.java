package com.humber.eap.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Aspect
@Component
@Log
public class MailAspect {
	//aspect to create functionality for the custom annotation - timecheck (i.e. calculate time taken for the method in home controller to execute)
	@Around("@annotation(com.humber.eap.annotation.TimeCheck)")
	public void aroundTimeCheck(ProceedingJoinPoint pjp) throws Throwable {
		long timeBefore = System.currentTimeMillis();
		pjp.proceed();
		long timeAfter = System.currentTimeMillis();
		log.info("Time taken to send the mail is  is " + (timeAfter-timeBefore) + " ms!");
	}
}
