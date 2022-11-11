package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.Course;
import com.sara.hibernateonetoone.entity.Instructor;
import com.sara.hibernateonetoone.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("sara", "afzar", "sara.afzar@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "http://youtube.com/sara",
                                    "coding movies");
            instructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
