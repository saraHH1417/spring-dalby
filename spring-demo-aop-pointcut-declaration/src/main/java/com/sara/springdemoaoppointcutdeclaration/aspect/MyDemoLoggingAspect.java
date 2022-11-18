package com.sara.springdemoaoppointcutdeclaration.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.sara.springdemoaoppointcutdeclaration.aspect.LuvAopExpressions.forDaoPackage()")
    public void beforeAddAllAccountAdvice() {
        System.out.println("\n==========> Executing @Before advice on all methods in a package with any name," +
                " any return type and any parameters using forDaoPackage PointCut");
    }

}


