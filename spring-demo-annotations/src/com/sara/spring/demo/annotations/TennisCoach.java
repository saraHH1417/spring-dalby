package com.sara.spring.demo.annotations;

import org.springframework.stereotype.Component;

@Component("theSillyCoach")

public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practice your backend volley";
    }
}
