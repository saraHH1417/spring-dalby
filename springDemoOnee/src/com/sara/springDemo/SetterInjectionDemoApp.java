package com.sara.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionDemoApp {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // call methods on the bean
        System.out.println(theCricketCoach.getDailyWorkout());
        System.out.println(theCricketCoach.getDailyFortune());
        // ... let's come back to this

        // call our new methods to get the literal values
        System.out.println(theCricketCoach.getEmailAddress());
        System.out.println(theCricketCoach.getTeam());


        // close the context
        context.close();
    }
}
