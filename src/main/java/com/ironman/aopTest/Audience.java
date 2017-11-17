package com.ironman.aopTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 10:07 2017/10/19 0019
 * @Modified by:
 **/
@Aspect
public class Audience {

	@Pointcut("execution(* com.ironman.aopTest.Performance.perform(String)) && args(sss)")
	public void performanceCut(String sss){
	}

	//	@Before("execution(* com.ironman.aopTest.Performance.perform(..))")
	@Before("performanceCut(sss)")
	public void silenceCellPhones(String sss){
		System.out.println("Silence cell phones: "+sss);
	}

	//	@Before("execution(* com.ironman.aopTest.Performance.perform(..))")
	@Before("performanceCut(sss)")
	public void takeTasks(String sss){
		System.out.println("Taking seats");
	}

	//	@AfterReturning("execution(* com.ironman.aopTest.Performance.perform(..))")
	@AfterReturning("performanceCut(sss)")
	public void applause(String sss){
		System.out.println("Clap Clap Clap");
	}

	//	@AfterThrowing("execution(* com.ironman.aopTest.Performance.perform(..))")
	@AfterThrowing("performanceCut(sss)")
	public void demandRefund(String sss){
		System.out.println("Demanding a refund");
	}

	@Around("performanceCut(sss)")
	public void watchPerformance(ProceedingJoinPoint joinPoint,String sss){
		try {
			System.out.println("around 1");
			joinPoint.proceed(new Object[]{sss});
			System.out.println("around 1");
		} catch(Throwable throwable){
			throwable.printStackTrace();
			System.out.println("Demanding a refund 1");
		}
	}
}
