package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.Course;
import com.sara.hibernateonetoone.entity.Instructor;
import com.sara.hibernateonetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {
        System.out.println("getting lazy loaded data with HQL(hibernate query language)");
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;
            System.out.println("Using Hibernate Query Language");
            Query<Instructor> query = session.createQuery(
                    "select i from Instructor i "
                            + "JOIN FETCH i.courses "
                            + "where i.id=:theInstructorId",
                    Instructor.class);

            query.setParameter("theInstructorId", theId);

            Instructor instructor = query.getSingleResult();
            System.out.println("Instructor: " + instructor);

            session.getTransaction().commit();


            System.out.println("The instructor courses:" + instructor.getCourses());
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
