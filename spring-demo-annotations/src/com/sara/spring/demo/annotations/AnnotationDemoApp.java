package com.sara.spring.demo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        Coach theCoach = context.getBean("theSillyCoach", Coach.class);
        Coach swimmingCoach =context.getBean("swimmingCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(swimmingCoach.getDailyWorkout());

        // close the context
        context.close();
    }
}
