package com.sara.spring.demo.annotations;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService{
    @Override
    public String getFortune() {
        return null;
    }
}
