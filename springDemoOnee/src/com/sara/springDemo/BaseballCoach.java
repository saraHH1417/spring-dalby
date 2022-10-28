package com.sara.springDemo;

import java.lang.annotation.Retention;

public class BaseballCoach implements Coach {
    private FortuneService fortuneService;

    public BaseballCoach() {

    }
    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return  "30 minutes every day";
    }

    @Override
    public String getDailyFortune() {
        // use my fortune service to a get a fortune
        return fortuneService.getFortune();
    }
}
