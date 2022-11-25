package com.sara.springcrmrest.rest;

import com.sara.springcrmrest.entity.Customer;
import com.sara.springcrmrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found");
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0); // for forcing to create a new record instead of updating
        customerService.saveCustomer(customer);

        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }


    @DeleteMapping("/customers/{customerId}")
    public Map<String, String> deleteCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            throw  new CustomerNotFoundException("Customer with id " + customerId + " not found.");
        }

        customerService.deleteCustomer(customerId);

        Map<String, String> result = new HashMap<>();
        result.put("message" , "Successfully deleted customer with id " + customerId);
        result.put("status", HttpStatus.ACCEPTED.toString());
        return result;
    }

}
