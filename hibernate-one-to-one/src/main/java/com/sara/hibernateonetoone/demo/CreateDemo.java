package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.Instructor;
import com.sara.hibernateonetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Instructor tempInstructor = new Instructor("sara", "afzar", "sara.afzar@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "http://saraGreat.test",
                    "Coding, movies"
            );

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("\nSaving instructor: " + tempInstructor);
            session.persist(tempInstructor); // because the cascade is all, this line also saves the detail object info

            session.getTransaction().commit();

            System.out.println("Done!!");
        }finally {
            sessionFactory.close();
        }
    }
}
