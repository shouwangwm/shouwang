package com.pro.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import com.pro.vo.TbCommodity;

@Aspect
public class Synchro {
	
	public void beforeNotice(){
		System.out.println("before");
	}
	
	public void afterNotice(){
		System.out.println("after");
	}
	
	public void finallyNotice(JoinPoint point){
		if(point.getArgs().length != 0){
			//System.out.println(((TbCommodity)point.getArgs()[0]).getCommName());
			System.out.println(point.getArgs()[0] instanceof TbCommodity);
		}
		System.out.println("finally");
	}
	
	public void exceptionNotice(){
		System.out.println("exception");
	}
	
	public Object aroundNotice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("进入方法");
		Object obj = pjp.proceed(); 
		System.out.println("退出方法");
		return obj;
	}


}
