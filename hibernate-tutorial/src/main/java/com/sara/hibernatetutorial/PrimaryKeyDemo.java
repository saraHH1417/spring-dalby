package com.sara.hibernatetutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
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
            System.out.println("Creating 3 student objects ...");
            Student tempStudentOne = new Student("John", "Doe" , "john@gmmail.com");
            Student tempStudentTwo = new Student("Mary", "Blue" , "mary@gmmail.com");
            Student tempStudentThree = new Student("Williams", "jury" , "williams@gmmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.persist(tempStudentOne);
            session.persist(tempStudentTwo);
            session.persist(tempStudentThree);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

        }

    }
}
