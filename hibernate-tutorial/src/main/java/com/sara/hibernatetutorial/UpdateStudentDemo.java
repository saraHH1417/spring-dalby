package com.sara.hibernatetutorial;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int studentId = 1;
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("The received student is: " + myStudent);

            System.out.println("Updating student...");
            myStudent.setFirstName("Hero");

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("New way for updating...");
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='test@gmailt.com'", Student.class)
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
