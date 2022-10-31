package com.sara.spring.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
}
