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

@WebServlet("/createSubjectServlet")
public class CreateSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		
		String name = request.getParameter("name");
		int gradePoints = Integer.parseInt(request.getParameter("gradePoints"));
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		SubjectEntity subject = new SubjectEntity(name,gradePoints);
		
		session.save(subject);
		
		session.getTransaction().commit();
		
		session.close();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Subject Added</h1>");
		out.println("<a href='createSubjectForm.html'>Create More?</a>");
	}
}
