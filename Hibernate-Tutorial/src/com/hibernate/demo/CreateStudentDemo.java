package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session ss = sf.getCurrentSession();

		try {

			System.out.println("Creating new Student Onjects");
			Student std = new Student("Tushar", "Agarwal", "abc@gmail.com");

			ss.beginTransaction();

			// save the object
			System.out.println("Saving the Student");
			ss.save(std);

			ss.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			sf.close();
		}

	}

}
