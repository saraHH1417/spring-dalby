package com.sara.springbootstart.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World! Time On service is " + LocalDateTime.now();
    }
}
