package com.cog.aspect;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RestrictFancyAccounts {
	
	List<Long> fancyAccounts;
	
	@PostConstruct
	public void init(){
		fancyAccounts = new ArrayList<>();
		fancyAccounts.add(11111111l);
		fancyAccounts.add(22222222l);
		fancyAccounts.add(33333333l);
	}

	@Before("execution(* com.cog.TransferService.*(..))")
	public void doLogging(JoinPoint joinPoint) throws Exception{
		Object[] args = joinPoint.getArgs();
		
		System.out.println("Inputs params passed are: ");
		for(Object arg : args){
			if(arg instanceof Long){
				System.out.println("Printing long argument " + arg);
				if(fancyAccounts.contains(arg)){
					throw new Exception("Fancy Accounts not allowed");
				}
			}
			
			
			System.out.println(arg);
		}
		
		System.out.println("Will be run before transfer service");
	}

}