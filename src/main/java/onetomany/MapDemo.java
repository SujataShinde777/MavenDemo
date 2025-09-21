package onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("onetomany/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Teacher t1 = new Teacher();
		t1.setTeacherId(101);
		t1.setName("RamaKrishna");
		
		Student s1 = new Student();
		s1.setStudentId(1101);
		s1.setStudentName("Rama");
		s1.setStudentCity("Pune");
		
		Student s2 = new Student();
		s2.setStudentId(1102);
		s2.setStudentName("Krishna");
		s2.setStudentCity("Mumbai");
		
		Student s3 = new Student();
		s3.setStudentId(1103);
		s3.setStudentName("Hari");
		s3.setStudentCity("Kolkata");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		t1.setStudents(list);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(t1);
		tx.commit();
		session.close();
		
		
		
	}
	
}
