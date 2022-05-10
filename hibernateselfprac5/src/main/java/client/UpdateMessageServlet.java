package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.Message;
import util.HibernateUtil;

@WebServlet("/updateMessageServlet")
public class UpdateMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Inside Post Method!");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String newMessageText = request.getParameter("newMessageText");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Message oldMessage = session.get(Message.class, id);
		
		String oldMessageText = oldMessage.getText();
		
		oldMessage.setText(newMessageText);
		
		session.saveOrUpdate(oldMessage);
		
		session.getTransaction().commit();
		
		session.close();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<h2>Changes have been made successfully.</h2>");
		out.println("<h2>Old Message Text : " + oldMessageText);
		out.println("<h2>Updated Message Text : " + newMessageText);
		out.println("<h2>Update More? <a href='updateMessageForm.html'>Click Here</a></h2>");
		out.close();
	}
}
