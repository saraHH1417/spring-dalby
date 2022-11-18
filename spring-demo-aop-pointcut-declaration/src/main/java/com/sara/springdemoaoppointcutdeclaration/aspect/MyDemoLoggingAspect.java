package com.sara.springdemoaoppointcutdeclaration.aspect;


import com.sara.springdemoaoppointcutdeclaration.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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


