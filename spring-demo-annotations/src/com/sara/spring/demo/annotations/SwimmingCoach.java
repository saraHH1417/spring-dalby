package com.sara.spring.demo.annotations;

import org.springframework.stereotype.Component;

@Component  // Here we use the default bean id which turns the first class name which is capital to the small letter
public class SwimmingCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Swim at least 15 minutes every day";
    }
}
