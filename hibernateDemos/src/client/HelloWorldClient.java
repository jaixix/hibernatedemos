package client;

//import com.mysql.cj.Session;
import org.hibernate.Session;
import domain.Message;
import util.HibernateUtil;

public class HelloWorldClient {
public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Message message = new Message("Hello again again from annotations");
				
		session.save(message);
		
		session.getTransaction().commit();
		session.close();
	}
}
