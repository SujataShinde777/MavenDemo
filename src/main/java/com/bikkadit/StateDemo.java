package com.bikkadit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class StateDemo {

	public static void main(String[] args) {
		
		System.out.println("example....");
		
		SessionFactory f = new Configuration()
				              .configure("com/bikkadit/hibernate.cfg.xml")
				             .buildSessionFactory();
		
		//creating student object
		Student student = new Student();
			student.setId(1414);
			student.setName("Peter");
			student.setCity("ABC");
			student.setCerti(new Certificate("Java Hibernate course","2 months"));
		//student : transient
			
			Session s = f.openSession();
			Transaction tx = s.beginTransaction();
			s.save(student);
	   //student : persistent 
			
			student.setName("John");
		
		//student : detach	  
			

			Student student2 = s.get(Student.class, 1414);
			System.out.println(student2);
			
		tx.commit();
		s.close();  
		//student : detach state
		
	//	student.setName("Sachin");
	//	System.out.println(student);
		
		f.close();
	}
}
