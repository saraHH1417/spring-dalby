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

    // add an init method
    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside  init-method");
    }

    // add a destroy method
    public void doMyDestroyStuff() {
        System.out.println("Track Coach: inside destroy-method");
    }
}
