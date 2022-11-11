package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.Course;
import com.sara.hibernateonetoone.entity.Instructor;
import com.sara.hibernateonetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);
            System.out.println("Instructor courses" + instructor.getCourses());

            session.getTransaction().commit();
            System.out.println("The session is now closed!:)\n");

            System.out.println("Instructor courses" + instructor.getCourses());

            System.out.println("Done!");

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            sessionFactory.close();
        }

    }
}
