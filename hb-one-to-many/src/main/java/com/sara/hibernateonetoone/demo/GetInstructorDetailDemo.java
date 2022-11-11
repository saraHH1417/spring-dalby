package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.Instructor;
import com.sara.hibernateonetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 2545;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("Temp Instructor Detail: " + tempInstructorDetail);
            System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());

            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            // handle connection leak issue
            session.close();
            sessionFactory.close();
        }
    }
}
