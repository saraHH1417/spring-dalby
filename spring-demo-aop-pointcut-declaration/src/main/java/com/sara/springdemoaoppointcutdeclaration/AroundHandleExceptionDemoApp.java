package com.sara.springdemoaoppointcutdeclaration;

import com.sara.springdemoaoppointcutdeclaration.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
                TrafficFortuneService.class);

        myLogger.info("\nMain program: AroundHandleExceptionDemoApp");
        myLogger.info("Calling getFortuneParam");

        boolean tripWire = true;
        String info = trafficFortuneService.getFortuneParam(tripWire);

        myLogger.info("\nMy Fortune is: " + info);
        myLogger.info("Finished!");

        context.close();
    }
}
