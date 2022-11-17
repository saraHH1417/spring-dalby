package com.sara.springdemoaoppointcutdeclaration.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount() {
        System.out.println(getClass() + ": Doing Stuff: Adding A Membership Account");
    }

    public boolean premiumAccount() {
        System.out.println("Premium account with boolean return type");
        return true;
    }
}
