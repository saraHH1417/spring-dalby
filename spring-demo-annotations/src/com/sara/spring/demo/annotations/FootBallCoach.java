package com.sara.spring.demo.annotations;

import org.springframework.beans.factory.annotation.Value;

public class FootBallCoach implements Coach {
    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
    public FootBallCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Practice. Football is a great sport";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
