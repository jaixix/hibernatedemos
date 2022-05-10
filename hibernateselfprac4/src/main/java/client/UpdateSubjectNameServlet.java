package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.SubjectEntity;
import util.HibernateUtil;
@WebServlet("/updateSubjectNameServlet")
public class UpdateSubjectNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String originalName = request.getParameter("originalName");
		String newName = request.getParameter("newName");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		SubjectEntity subject1 = session.get(SubjectEntity.class, id);
		subject1.setName(newName);
		
		session.saveOrUpdate(subject1);
		session.getTransaction().commit();
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>Subject ID : "+ subject1.getId() + "has been renamed from " + originalName + " to " + newName +"</h2>");
		session.close();
		out.close();
	}
}
