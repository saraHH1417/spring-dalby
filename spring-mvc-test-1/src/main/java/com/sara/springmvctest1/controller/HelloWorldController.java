package com.sara.springmvctest1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/helloworld")
    public String handler(Model model) {
        return "helloworld";
    }

}
