package com.sara.springdemoaop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // let's start with @Before advice
    @Before("execution(public void com.sara.springdemoaop.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount()");
    }

    // execute @before on all updateAccount methods with any return type
    @Before("execution(public * updateAccount())")
    public void beforeUpdateAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on updateAccount method");
    }

    @Before("execution(boolean premiumAccount())")
    public void beforePremiumAccount() {
        System.out.println("\n======> Executing @Before advice on premiumAccount() method which it's return type is boolean");
    }

    // modifier is optional (private, protected, public)  return type is required if we want to cover
    // all return types we can use *
    @Before("execution(* add*())")
    public void beforeAddStartAdvice() {
        System.out.println("\n======> Executing @Before advice on all methods that start with add (* add*())");
    }


}


