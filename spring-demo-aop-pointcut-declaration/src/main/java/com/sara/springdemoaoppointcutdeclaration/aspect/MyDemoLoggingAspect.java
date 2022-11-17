package com.sara.springdemoaoppointcutdeclaration.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging
    @Pointcut("execution(* com.sara.springdemoaoppointcutdeclaration.dao.*.*(..))")
    private void forDaoPackage() {};

    // create pointcut for getter methods
    @Pointcut("execution(* com.sara.springdemoaoppointcutdeclaration.dao.*.get*(..))")
    private void getter() {};

    //create pointcut for setter methods
    @Pointcut("execution(* com.sara.springdemoaoppointcutdeclaration.dao.*.set*(..))")
    private void setter() {};

    //create pointcut: include package ...exclude getters/setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {};

    @Before("forDaoPackage()")
    public void beforeAddAllAccountAdvice() {
        System.out.println("\n==========> Executing @Before advice on all methods in a package with any name," +
                " any return type and any parameters using forDaoPackage PointCut");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====> Performing API analytics using forDaoPackage Pointcut");
    }
}


