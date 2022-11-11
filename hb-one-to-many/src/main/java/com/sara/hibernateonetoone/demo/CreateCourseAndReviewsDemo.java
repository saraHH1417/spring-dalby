package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.Course;
import com.sara.hibernateonetoone.entity.Instructor;
import com.sara.hibernateonetoone.entity.InstructorDetail;
import com.sara.hibernateonetoone.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Course course = new Course("tik tok");

            course.addReview(new Review("Great Course"));
            course.addReview(new Review("fantastic"));
            course.addReview(new Review("Could be better"));

            System.out.println("Saving the course: " + course);
            session.save(course);

            System.out.println("Course Reviews: " + course.getReviews());
            session.getTransaction().commit();
        } catch (Exception exception) {

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
