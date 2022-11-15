package com.sara.webcustomertracker.controller;

import com.sara.webcustomertracker.dao.CustomerDao;
import com.sara.webcustomertracker.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;
    @RequestMapping(name = "customers-list", value = "/list")
    public String listCustomers(Model theModel) {
        List<Customer> customers = customerDao.getCustomers();
        for (Customer customer: customers) {
            System.out.println(customer);
            System.out.println(customer.getFirstName());
        }
        theModel.addAttribute("customers",customers);
        return "list-customers";
    }
}
