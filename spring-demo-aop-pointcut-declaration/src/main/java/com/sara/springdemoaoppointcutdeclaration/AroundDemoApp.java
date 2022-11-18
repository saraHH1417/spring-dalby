package com.sara.springdemoaoppointcutdeclaration;

import com.sara.springdemoaoppointcutdeclaration.dao.AccountDAO;
import com.sara.springdemoaoppointcutdeclaration.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
                TrafficFortuneService.class);

        String info = trafficFortuneService.getFortune();
        System.out.println("\nMy Fortune is: " + info);

        System.out.println("Finished");
        context.close();
    }
}
