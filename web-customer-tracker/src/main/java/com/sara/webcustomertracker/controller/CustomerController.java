package com.sara.webcustomertracker.controller;

import com.sara.webcustomertracker.dao.CustomerDao;
import com.sara.webcustomertracker.entity.Customer;
import com.sara.webcustomertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    //need to inject our customer service
    @Autowired
    private CustomerService customerService;


    @GetMapping(value = "/list")
    public String listCustomers(Model theModel) {
        List<Customer> customers = customerService.getCustomers();
        theModel.addAttribute("customers",customers);
        return "list-customers";
    }
}
