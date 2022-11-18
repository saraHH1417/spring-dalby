package com.sara.springdemoaoppointcutdeclaration;

import com.sara.springdemoaoppointcutdeclaration.dao.AccountDAO;
import com.sara.springdemoaoppointcutdeclaration.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        theAccountDAO.addAccount();

        System.out.println("\n Let's call the addAccount method again");
        theAccountDAO.addAccount();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addAccount();

        System.out.println("\n\n");
        theAccountDAO.premiumAccount();

        membershipDAO.premiumAccount();

        System.out.println("\nTesting match method parameters:");
        Account account = new Account();
        account.setName("Sara");
        account.setLevel("Perfect");
        theAccountDAO.addAccountWithParam(account);
        theAccountDAO.addAccountWithMultipleParam(account, true);
        theAccountDAO.beforeAllPackageMethodsAspect();
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        context.close();

    }
}
