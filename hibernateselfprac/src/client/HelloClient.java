package client;

import org.hibernate.Session;

import entity.Message;
import util.HibernateUtil;

public class HelloClient {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Message msg = new Message("Hello World");
		session.save(msg);
		session.getTransaction().commit();
		session.close();
	}
}
