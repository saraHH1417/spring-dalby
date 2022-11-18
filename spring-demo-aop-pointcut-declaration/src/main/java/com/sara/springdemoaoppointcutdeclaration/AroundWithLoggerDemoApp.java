package com.sara.springdemoaoppointcutdeclaration;

import com.sara.springdemoaoppointcutdeclaration.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
                TrafficFortuneService.class);
        myLogger.info("\nMain Program: around with logger demo app");
        myLogger.info("Calling getFortune");

        String info = trafficFortuneService.getFortune();
        myLogger.info("\nMy Fortune is: " + info);

        myLogger.info("Finished");
        context.close();
    }
}
