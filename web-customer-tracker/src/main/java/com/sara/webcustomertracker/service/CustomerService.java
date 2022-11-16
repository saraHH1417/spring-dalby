package com.sara.webcustomertracker.service;

import com.sara.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();
    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);
}
