package com.sara.hibernatetutorial;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // query students
            TypedQuery<Student> studentQuery = session.createQuery("from Student ");
            List<Student> theStudents = studentQuery.getResultList();
//            List<Student> students = session.createQuery("from Student ").getResultList();
            // display the students
            System.out.println("\nDisplay all students");
            displayStudents(theStudents);

            // query students firstName = "Paul"
            List<Student> newStudents = session.createQuery("from Student s where s.firstName = 'Paul'").getResultList();

            // display the students
            System.out.println("\n\nStudent who have first name of Paul");
            displayStudents(newStudents);

            // query students who have lastName of 'Doe' Or firstName = 'Paul'
            System.out.println("\n\nStudents who have lastName of 'Doe' Or firstName = 'Paul'");
            List<Student> DoePaulStudents = session
                    .createQuery("from Student s where s.lastName = 'Doe'" +
                    "OR s.firstName = 'Paul'")
                    .getResultList();
            displayStudents(DoePaulStudents);


            // query students with email
            System.out.println("\n\nQuery students by their email");
            List<Student> emailStudents= session
                    .createQuery("from Student s where s.email like '%gmmail.com'")
                    .getResultList();
            displayStudents(emailStudents);

            // commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student tempStudent: students) {
            System.out.println(tempStudent);
        }
    }
}
