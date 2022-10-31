package com.sara.spring.demo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
//        Coach theCoach = context.getBean("theSillyCoach", Coach.class);
        Coach swimmingCoach =context.getBean("swimmingCoach", Coach.class);
        Coach chessCoach = context.getBean("chessCoach", Coach.class);
        Coach rugbyCoach = context.getBean("rugbyCoach", Coach.class);

        // call a method on the bean
//        System.out.println(theCoach.getDailyWorkout());
        System.out.println(swimmingCoach.getDailyWorkout());
        System.out.println(chessCoach.getDailyWorkout());
        System.out.println(rugbyCoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println("The below class is using constructor injection");
//        System.out.println(theCoach.getDailyFortune());

        System.out.println("Te below class is using setter injection");
        System.out.println(swimmingCoach.getDailyFortune());

        System.out.println("The below class is using method(not constructor) injection");
        System.out.println(chessCoach.getDailyFortune());

        System.out.println("The below class is using field injection");
        System.out.println(rugbyCoach.getDailyFortune());
        // close the context
        context.close();
    }
}
