package org.mjmayor.jpa.interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.springframework.dao.DataAccessException;

@Aspect
public class JPAInterceptor {

	@Pointcut("execution(@org.springframework.transaction.annotation.Transactional * *(..))")
	public void transactionalMethod() {
	}

	@AfterReturning("transactionalMethod()")
	public void afterTransactionalMethod(JoinPoint joinPoint) {
		// TODO mjmayor Codigo a ejecutar despues de una transaccion
	}

	@AfterThrowing(pointcut = "transactionalMethod()", throwing = "e")
	public void afterThrowingFromTransactionalMethod(JoinPoint joinPoint, DataAccessException e) throws JPAPersistenceException {
		// TODO mjmayor Excepcion a lanzar cuando proceda despues de una transaccion
	}
}
