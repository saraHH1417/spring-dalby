package com.sara.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        Coach theLifeCycleCoach = context.getBean("myLifeCycleCoach", Coach.class);

        System.out.println(theLifeCycleCoach.getDailyWorkout());

        context.close();
    }
}
