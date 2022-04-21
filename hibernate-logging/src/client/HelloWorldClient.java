package client;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import entity.Message;
import util.HibernateUtil;

public class HelloWorldClient {
	static Logger logger = Logger.getLogger(HelloWorldClient.class.getName());

	public static void main(String[] args) {
		
//		logger.debug("this is a debug message from helloworldclient");
//		
//		logger.info("this is a info message from helloworldclient");
//		
//		logger.trace("this is a trace message from helloworldclient");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		logger.trace("Retrieved SessionFactory");
		
		session.beginTransaction();
		logger.trace("Begun Transaction");
		
		Message message = new Message("Hello again from annotations-logging-ALL");
				
		session.save(message);
		logger.trace("Successfully save message");
		
		session.getTransaction().commit();
		logger.trace("Transaction committed");
		session.close();
	}
}
