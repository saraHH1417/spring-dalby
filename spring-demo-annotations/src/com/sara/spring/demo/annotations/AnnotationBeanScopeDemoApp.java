package com.sara.spring.demo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("theSillyCoach", Coach.class);
        Coach alphaCoach = context.getBean("theSillyCoach", Coach.class);

        Coach swimmingCoach = context.getBean("swimmingCoach", Coach.class);
        Coach swimmingCoachTwo = context.getBean("swimmingCoach", Coach.class);

        // check if they are the same
        boolean resultSingleton = (theCoach == alphaCoach);
        boolean resultPrototype = (swimmingCoach == swimmingCoachTwo);

        // print out the results
        System.out.println("\nPointing to the same object(because the default scope is singleton): " + resultSingleton);
        System.out.println("\nMemory location for the coach: " + theCoach);
        System.out.println("\nMemory location for alpha coach: " + alphaCoach + "\n");

        System.out.println("\nPointing to the same object(prototype scope): " + resultPrototype);
        System.out.println("\nMemory location for the swimming Coach: " + swimmingCoach);
        System.out.println("\nMemory location for the swimming coach: " + swimmingCoachTwo);
        // close the context
        context.close();
    }
}
