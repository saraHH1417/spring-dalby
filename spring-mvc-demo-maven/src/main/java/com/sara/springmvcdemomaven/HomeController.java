package com.sara.springmvcdemomaven;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/main-menu")
    public String showMain() {
        return "main-menu";
    }
}
