package com.sara.spring.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("theSillyCoach")
public class TennisCoach implements Coach{
    private FortuneService fortuneService;

    @Autowired
    public TennisCoach(@Qualifier("databaseFortuneService") FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "practice your backend volley";
    }

    //define a setter method


    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // define my init method
//    @PostConstruct postConstruct and PreDestroy have been removed in java 9 because they belong to java ee.
    // In case we need them, We should add them to the dependencies
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
    }

    // define my destroy method
//    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> Tennis Coach: inside of doMyCleanUpStuff()");
    }
}
