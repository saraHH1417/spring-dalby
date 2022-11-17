package com.sara.springdemoaop.dao;

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
}
