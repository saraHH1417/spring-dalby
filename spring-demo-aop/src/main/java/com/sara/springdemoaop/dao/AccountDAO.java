package com.sara.springdemoaop.dao;

import com.sara.springdemoaop.Account;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + " :Doing my db work, adding an account on AccountDao class");
    }

    public int premiumAccount() {
        System.out.println("Premium account with integer return type");
        return 1;
    }

    public void addAccountWithParam(Account account) {
        System.out.println(getClass() + " : Doing my db work, adding an account with Account class param");
    }

    public void addAccountWithMultipleParam(Account account, boolean flag) {
        System.out.println("add Account method with Account param and multiple other params");
    }

    public void beforeAllPackageMethodsAspect() {
        System.out.println("\nExecuting @Before advice for all methods in a package");
    }
}
