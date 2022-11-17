package com.sara.springdemoaoppointcutdeclaration.dao;

import com.sara.springdemoaoppointcutdeclaration.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;
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

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
