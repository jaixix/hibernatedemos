package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.session.SessionMessage;
import org.hibernate.Session;

import entity.Message;
import util.HibernateUtil;

@WebServlet("/createMessageServlet")

public class CreateMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		String text = request.getParameter("text");
		
		//Open a session.
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Begin a transaction.
		session.beginTransaction();
		//Create Object for Message Class.
		Message msg = new Message(text);
		//Save object to session.
		session.save(msg);
		//Commit changes to DB.
		session.getTransaction().commit();
		//Close session.
		session.close();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>New Message has been created and added to the DB!</h2>");
		out.println("<h2>Create More? <a href='createMessageForm.jsp'>Click Here</a></h2>");
		out.close();
	}
}
