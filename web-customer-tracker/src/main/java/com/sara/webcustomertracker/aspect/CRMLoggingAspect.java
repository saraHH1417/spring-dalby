package com.sara.webcustomertracker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.sara.webcustomertracker.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.sara.webcustomertracker.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.sara.webcustomertracker.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint) {
        String theMethod = joinPoint.getSignature().toShortString();
        myLogger.info("===========> in @Before calling method:" + theMethod);

        Object[] args = joinPoint.getArgs();
        for(Object arg: args) {
            myLogger.info("====> argument: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("===> in @AfterReturning from method: " + method);

        myLogger.info("======> result: " + result);
    }
}
