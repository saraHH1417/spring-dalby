package com.sara.webcustomertracker.dao;

import com.sara.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getCustomers();
}
