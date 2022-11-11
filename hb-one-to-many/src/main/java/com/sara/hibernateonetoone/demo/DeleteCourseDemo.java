package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.Course;
import com.sara.hibernateonetoone.entity.Instructor;
import com.sara.hibernateonetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            int theId = 10;
            Course course = session.get(Course.class, theId);

            System.out.println("Deleting course: " + course);

            if (course != null) {
                session.delete(course);
                session.getTransaction().commit();
                System.out.println("Done!");
            } else {
                System.out.println("The course with id " + theId + " doesn't exist");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
