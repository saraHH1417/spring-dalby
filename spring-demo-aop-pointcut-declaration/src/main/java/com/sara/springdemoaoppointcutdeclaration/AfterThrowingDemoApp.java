package com.sara.springdemoaoppointcutdeclaration;

import com.sara.springdemoaoppointcutdeclaration.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;

        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccountsParam(tripWire);

        }catch (Exception exception) {
            System.out.println("\n=======> Main Program.... caught exception");
        }
    }
}
