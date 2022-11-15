package com.sara.webcustomertracker.dao;

import com.sara.webcustomertracker.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        // create a query
        Query<Customer> theQuery = session.createQuery("from Customer", Customer.class);
        // execute the query and get the result
        List<Customer> customers = theQuery.getResultList();
        for (Object customer:
             customers) {
            System.out.println();
        }
        // return the results
        return customers;
    }
}
