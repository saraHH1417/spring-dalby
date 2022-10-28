package com.sara.springDemo;

public class MyApp {
    public static void main(String[] args) {
        Coach theCoach = new BaseballCoach();
        Coach trackCoach = new TrackCoach();

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyWorkout());

    }
}
