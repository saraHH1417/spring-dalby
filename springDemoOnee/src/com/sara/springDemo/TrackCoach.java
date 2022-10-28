package com.sara.springDemo;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;
    public TrackCoach() {

    }
    public TrackCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it " + fortuneService.getFortune();
    }
}
