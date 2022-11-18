package com.sara.springdemoaoppointcutdeclaration;

import com.sara.springdemoaoppointcutdeclaration.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;

        System.out.println("\nFailure method Case");
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccountsParam(tripWire);
        } catch (Exception exception) {
            System.out.println("\nMain program......... caught exception");
        }

        System.out.println("Success method case");
        boolean tripWire = false;
        accounts = accountDAO.findAccountsParam(tripWire);
    }
}
