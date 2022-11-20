package com.sara.springsecuritydemobasicsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

    @GetMapping("/systems")
    public String showMySystems() {
        return "systems";
    }
}
