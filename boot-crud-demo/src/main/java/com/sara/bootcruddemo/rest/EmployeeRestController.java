package com.sara.bootcruddemo.rest;

import com.sara.bootcruddemo.entity.Employee;
import com.sara.bootcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    // quick and dirty: inject employee dao (using constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return  employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable int employeeId) {
        Optional<Employee> theEmployee = employeeService.findById(employeeId);

        if(theEmployee.isEmpty()) {
           throw new RuntimeException("Employee with id " + employeeId + " not found.");
        }
        return  theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // we put below line because it is possible that they pass an id in the request
        theEmployee.setId(0);

        employeeService.save(theEmployee);

        return  theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.save(theEmployee);

        return  theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Optional<Employee> tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee.isEmpty()) {
            throw new RuntimeException("Employee with id " + employeeId + " not found.");
        }

        employeeService.deleteById(employeeId);

        return  "Delete Employee id - " + employeeId;
    }
}
