package com.sara.spring.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RugbyCoach implements Coach{
    @Autowired
    @Qualifier("RESTFortuneService")
    private FortuneService fortuneService;

    public RugbyCoach() {
        System.out.println("Inside Rugby Coach default constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Rugby";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
