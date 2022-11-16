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
public class CustomerDaoImpl implements CustomerDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {
        Session session = getSession(sessionFactory);

        // create a query
        Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
        // execute the query and get the result
        List<Customer> customers = theQuery.getResultList();
        for (Object customer:
             customers) {
            System.out.println();
        }
        // return the results
        return customers;
    }

    public void saveCustomer(Customer theCustomer) {
        Session session = getSession(sessionFactory);
        // apparently the saveOrUpdate method doesn't work, so for now I use another way
        // for updating until I figure out why saveOrUpdate doesn't work
        Customer previousCustomer = session.get(Customer.class, theCustomer.getId());
        if (previousCustomer != null) {
            System.out.println("existssssssssssssssssss");;
            previousCustomer.setFirstName(theCustomer.getFirstName());
            previousCustomer.setLastName(theCustomer.getLastName());
            previousCustomer.setEmail(theCustomer.getEmail());
            System.out.println(previousCustomer);
            session.save(previousCustomer);
            session.update(previousCustomer);
        }  else {
            session.save(theCustomer);
        }
//        session.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {

        Session session = getSession(sessionFactory);
        return session.get(Customer.class, theId);
    }


    private Session getSession(SessionFactory sessionFactory) {
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}
