package com.sara.hibernatetutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            int studentId = 1;
            Student myStudent = session.get(Student.class, studentId);


            // delete the student
            System.out.println("\nDeleting student with id 1: ");
            session.delete(myStudent);

            // delete student with id 2
            System.out.println("\nDeleting student with id 2:");
            session.createNativeQuery("delete from student where id = 2", Student.class)
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
