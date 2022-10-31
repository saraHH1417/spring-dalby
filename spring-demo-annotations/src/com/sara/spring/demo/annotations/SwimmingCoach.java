package com.sara.spring.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
// Here we use the default bean id which turns the first class name which is capital to the small letter
public class SwimmingCoach implements Coach{
    private FortuneService fortuneService;

    public SwimmingCoach() {
        System.out.println(">> Swimming Coach: inside default constructor");
    }
    @Autowired
    @Qualifier("happyFortuneService")
    public void setFortuneService(FortuneService theFortuneService) {
        System.out.println(">> Swimming Coach: inside setFortuneService() method");
        this.fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Swim at least 15 minutes every day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


}
