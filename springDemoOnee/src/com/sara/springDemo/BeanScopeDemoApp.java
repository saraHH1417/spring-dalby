package com.sara.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("mySingletonCoach", Coach.class);
        Coach alphaCoach = context.getBean("mySingletonCoach", Coach.class);

        // check if these are the same (because the default scope is singlethon )
        boolean result = (theCoach == alphaCoach);

        System.out.println("\nPointing the same object: " + result);
        System.out.println("Memory location for the coach: " + theCoach);
        System.out.println("Memory location for alphaCoach: " + alphaCoach);

        Coach prototypeCoach = context.getBean("myPrototypeCoach", Coach.class);
        Coach prototypeCoach2 = context.getBean("myPrototypeCoach", Coach.class);

        // check if these are the same
        boolean protoResult = (prototypeCoach == prototypeCoach2);

        System.out.println("\nPointing the same object: " + protoResult);
        System.out.println("Memory location for the prototype coach1: " + prototypeCoach);
        System.out.println("Memory location for prototype coach2: " + prototypeCoach2);

        context.close();

    }
}
