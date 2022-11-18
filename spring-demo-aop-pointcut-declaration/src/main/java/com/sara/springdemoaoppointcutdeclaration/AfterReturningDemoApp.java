package com.sara.springdemoaoppointcutdeclaration;

import com.sara.springdemoaoppointcutdeclaration.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDao = context.getBean("accountDAO" , AccountDAO.class);

        List<Account> accounts = theAccountDao.findAccounts();

        System.out.println("\nMain Program: AfterReturningDemoApp");

        System.out.println("\n");
        context.close();
    }
}
