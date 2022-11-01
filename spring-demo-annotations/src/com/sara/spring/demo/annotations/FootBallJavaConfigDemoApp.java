package com.sara.spring.demo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FootBallJavaConfigDemoApp {
    public static void main(String[] args) {
        // load the spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from config file
        FootBallCoach footBallCoach = context.getBean("footBallCoach", FootBallCoach.class);

        System.out.println(footBallCoach.getDailyFortune());
        System.out.println(footBallCoach.getDailyWorkout());

        // call our swim coach methods ... has the props values injected
        System.out.println("email: " + footBallCoach.getEmail());
        System.out.println("team: " + footBallCoach.getTeam());

        // close the context
        context.close();
    }
}
