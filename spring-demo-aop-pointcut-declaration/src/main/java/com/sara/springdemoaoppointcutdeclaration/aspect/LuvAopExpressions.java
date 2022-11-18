package com.sara.springdemoaoppointcutdeclaration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpressions {
    // this is where we add all of our related advices for logging
    @Pointcut("execution(* com.sara.springdemoaoppointcutdeclaration.dao.*.*(..))")
    public void forDaoPackage() {};

    // create pointcut for getter methods
    @Pointcut("execution(* com.sara.springdemoaoppointcutdeclaration.dao.*.get*(..))")
    public void getter() {};

    //create pointcut for setter methods
    @Pointcut("execution(* com.sara.springdemoaoppointcutdeclaration.dao.*.set*(..))")
    public void setter() {};

    //create pointcut: include package ...exclude getters/setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {};
}
