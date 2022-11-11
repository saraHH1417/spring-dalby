package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.Instructor;
import com.sara.hibernateonetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            System.out.println("Instructor detail: " + tempInstructorDetail);

            if(tempInstructorDetail != null) {
                Instructor instructor = tempInstructorDetail.getInstructor();
                System.out.println("Get Associated Instructor: " + instructor);

                //break bi-directional link
                tempInstructorDetail.getInstructor().setInstructorDetail(null);

                System.out.println("Deleting instructor detail");
                session.delete(tempInstructorDetail);
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch(Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
