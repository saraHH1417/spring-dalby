package com.sara.thymeleafdemo.controller;

import com.sara.thymeleafdemo.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadDate() {
        Employee employee1 = new Employee(1, "sara", "afzar", "sara.afzar@gmailcom");
        Employee employee2 = new Employee(2, "ds", "hgh", "sd@gmail.com");
        Employee employee3 = new Employee(3, "sara", "afzar", "sara.afzar@gmailcom");
        Employee employee4 = new Employee(4, "sara", "afzar", "sara.afzar@gmailcom");
        theEmployees = new ArrayList<>();

        theEmployees.add(employee1);
        theEmployees.add(employee2);
        theEmployees.add(employee3);
        theEmployees.add(employee4);
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
