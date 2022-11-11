package com.sara.hibernateonetoone.demo;

import com.sara.hibernateonetoone.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudentDemo {
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

            int studentId = 1;
            Student student = session.get(Student.class, studentId);

            System.out.println("\nLoaded Student: " + student);
            System.out.println("Student Courses: " + student.getCourses());

            Course course1 = new Course("Desutsch B2");
            Course course2 = new Course("Jadfpanese A1");

            course1.addStudent(student);
            course2.addStudent(student);

            session.save(course1);
            session.save(course2);

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
