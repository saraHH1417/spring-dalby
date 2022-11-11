package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.Course;
import com.sara.hibernateonetoone.entity.Instructor;
import com.sara.hibernateonetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {
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

            int theId = 5;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            Course course1 = new Course("Air guffitar - The ultimate guide");
            Course course2 = new Course("The pifgnball");

            tempInstructor.addCourse(course1);
            tempInstructor.addCourse(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
