package com.sara.webcustomertracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {


    @RequestMapping(name = "customers-list" ,value = "/customers-list")
    public String listCustomers() {
        System.out.println("Hello");
        return "list-customers";
    }
}
