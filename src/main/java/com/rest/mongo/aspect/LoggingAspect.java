package com.rest.mongo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rest.mongo.model.Note;

@Aspect
@Component
public class LoggingAspect 
{	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	
//	@Before(value="execution(* com.rest.mongo.service.*(..))")
//	public void beforeAdviceAll(JoinPoint joinpoint)
//	{
//		System.out.println("Before Advice for All Methods Execution "+joinpoint.getSignature());
//		
//		logger.info("Methods executed successfully ");
//	}
	
	@Before(value="execution(* com.rest.mongo.controller.NoteController.*(..)) && args(noteObj)")
	public void beforeAdvice(JoinPoint joinpoint, Note noteObj)
	{
		System.out.println("Before Method Execution "+joinpoint.getSignature());
		System.out.println("Creating the Note Object with following details ...");
		
		logger.info("Creating the Note Object with following details ...");
		logger.info("Before Method Execution "+joinpoint.getSignature());
		logger.info(noteObj.getTitle()+"  "+noteObj.getText());
	}

	@After(value="execution(* com.rest.mongo.controller.NoteController.*(..)) && args(noteObj)")
	public void afterAdvice(JoinPoint joinpoint, Note noteObj)
	{
		System.out.println("After Method Execution "+joinpoint.getSignature());
		System.out.println("Creating the Note Object with following details ...");
		
		logger.info("Creating the Note Object with following details ...");
		logger.info("After Method Execution "+joinpoint.getSignature());
		logger.info(noteObj.getTitle()+"  "+noteObj.getText());
	}
}