package com.sara.springdemoaoppointcutdeclaration.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune(){

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return "Expect heavy traffic this morning";
    }

    public String getFortuneParam(Boolean tripWire) {

        if (tripWire) {
            throw  new RuntimeException("Major accident! Highway is closed!");
        }

        return getFortune();
     }
}
