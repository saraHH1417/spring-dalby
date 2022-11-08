package com.sara.hibernatetutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory =
                new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Paul", "Wall" , "sara.afzar@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.persist(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

        }

    }
}
