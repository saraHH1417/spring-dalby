package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.Instructor;
import com.sara.hibernateonetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            int theId = 1;
            Instructor tempInstructor= session.get(Instructor.class, theId);

            if (tempInstructor != null) {
                System.out.println("Found instructor with id: " + theId);
                // the below line also details the associated details object
                // becuase the cascade type is all
                session.delete(tempInstructor);
            } else {
                System.out.println("Instructor doesn't exist");
            }

        } finally {

        }

    }
}
