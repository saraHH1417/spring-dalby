package com.sara.springdemoaoppointcutdeclaration.aspect;


import com.sara.springdemoaoppointcutdeclaration.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.sara.springdemoaoppointcutdeclaration.service" +
            ".TrafficFortuneService.getFortuneParam(..))")
    public Object aroundGetFortuneParam(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n======> Executing @Around on method: " + method);

        long beginTime = System.currentTimeMillis();
        Object result = null;
         try {
             result = proceedingJoinPoint.proceed();
         } catch (Exception exception) {
             myLogger.warning(exception.getMessage());

             result = "Major Accident! But no worries, Your AOP helicopter is on the way";
         }

        long endTime = System.currentTimeMillis();

        long duration = endTime - beginTime;
        myLogger.info("\n=======> Duration: " + duration/ 1000.0 + " seconds");

        return result;
    }

    @Around("execution(* com.sara.springdemoaoppointcutdeclaration.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n======> Executing @Around on method: " + method);

        long beginTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long duration = endTime - beginTime;
        myLogger.info("\n=======> Duration: " + duration/ 1000.0 + " seconds");

        return result;
    }


    @After("execution(* com.sara.springdemoaoppointcutdeclaration.dao.AccountDAO.findAccountsParam(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===========> Executing @After (finally) on method" + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.sara.springdemoaoppointcutdeclaration.dao.AccountDAO.findAccountsParam(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n==========> Executing @AfterThrowing on method: " + method);

        // log rh exception
        System.out.println("\n==========> THe exception is: " + theExc);
    }

    // add anew advice for @AfterReturning on the findAccount method
    @AfterReturning(
            pointcut="execution(* com.sara.springdemoaoppointcutdeclaration.dao.AccountDAO.findAccounts(..))",
            returning="result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========> Executing @AfterReturning on method: " + method);

        convertAccountNamesToUpperCase(result);
        System.out.println("\n=========> Result is: " + result);
        
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount: result) {
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.sara.springdemoaoppointcutdeclaration.aspect.LuvAopExpressions.forDaoPackage()")
    public void beforeAddAllAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n==========> Executing @Before advice on all methods in a package with any name," +
                " any return type and any parameters using forDaoPackage PointCut");

        // display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments
        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg: args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

}


