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

@WebServlet("/deleteMessageServlet")
public class DeleteMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Message msg = session.get(Message.class, id);
		session.delete(msg);
		session.getTransaction().commit();
		session.close();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>Message : '" + msg.getText() + "' has been deleted from the DB!</h2>");
		out.println("<h2>Delete More? <a href='deleteMessageForm.html'>Click Here</a></h2>");
		out.close();
	}
}