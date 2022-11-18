package com.sara.springdemoaoppointcutdeclaration.aspect;


import com.sara.springdemoaoppointcutdeclaration.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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

