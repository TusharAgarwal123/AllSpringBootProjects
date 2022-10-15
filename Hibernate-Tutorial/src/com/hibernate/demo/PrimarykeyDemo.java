package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimarykeyDemo {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session ss = sf.getCurrentSession();

		try {

			System.out.println("Creating 3 new Student Onjects");
			Student std1 = new Student("Tushar", "Agarwal", "abc@gmail.com");
			Student std2 = new Student("Rohit", "Sharma", "xyz@gmail.com");
			Student std3 = new Student("Virat", "Kohli", "uvw@gmail.com");

			ss.beginTransaction();

			// save the object
			System.out.println("Saving the Students");
			ss.save(std1);
			ss.save(std2);
			ss.save(std3);

			ss.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			sf.close();
		}

	}
}
