package client;

import org.hibernate.Session;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;

public class MappingAssociationsClient {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Guide cl = new Guide("ab12cd34", "Cersie Lannister", 40000);
		
		Student john = new Student("ef56gh78", "John Snow", cl);
		
		Student tyrion = new Student("ij89kl12", "Tyrion Lannister", cl);
		
		Guide ec = new Guide("vf43fg54", "Emilia Clarke", 2000);
		
		Student mary = new Student("abc767fg54", "Mary Jane", ec);
		
		session.save(cl);
		session.save(john);
		session.save(tyrion);
		
		session.save(ec);
		session.save(mary);
		
		session.getTransaction().commit();
		
		session.close();
	}
}
