package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.SubjectEntity;
import util.HibernateUtil;

@WebServlet("/deleteSubjectServlet")
public class DeleteSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		SubjectEntity subject1 = session.get(SubjectEntity.class, id);
		
		session.delete(subject1);
		
		session.getTransaction().commit();
		session.close();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<h2>" + subject1.getName() + " has been deleted successfully.</h2>");
		out.close();
	}
}
