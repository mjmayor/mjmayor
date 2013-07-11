package org.mjmayor.jpa.interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;

@Aspect
public class JPAInterceptor {

	@Pointcut("execution(@org.springframework.transaction.annotation.Transactional * *(..))")
	public void transactionalMethod() {
	}
	
	@AfterReturning("transactionalMethod()")
    public void afterTransactionalMethod(JoinPoint joinPoint) {
        System.out.println("hola");
    }

	@AfterThrowing(pointcut = "transactionalMethod()", throwing = "e")
	public void afterThrowingFromTransactionalMethod(JoinPoint joinPoint, RuntimeException e) throws JPAPersistenceException {
		throw new JPAPersistenceException(e);
	}
}
