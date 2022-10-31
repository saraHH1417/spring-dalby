package com.sara.spring.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class ChessCoach implements Coach{
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "You know practicing chess makes the brain stronger, so the more practice the better";
    }

    @Autowired
    @Qualifier("randomService")
    public void doSomeCrazyStuff(FortuneService theFortuneService) {
        System.out.println("Autowiring; inside doSomeCrazyStuff method");
        fortuneService = theFortuneService;
    }
    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
