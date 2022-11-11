package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Course course = new Course("Deutsch C1");
            System.out.println("\nSaving the course ...");
            session.save(course);
            System.out.println("Course saved " + course);

            Student student1 = new Student("John", "Doe" , "j.doe@test.com");
            Student student2 = new Student("Mary" , "Blue" , "m.blue@test.com");

            course.addStudent(student1);
            course.addStudent(student2);
            session.save(student1);
            session.save(student2);

            System.out.println("Course students: " + course.getStudents());
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
