package client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.SubjectEntity;
import util.HibernateUtil;

@WebServlet("/readSubjectServlet")
public class ReadSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get Method!");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<SubjectEntity> subjects = session.createQuery("from SubjectEntity").list();
		request.setAttribute("subjects", subjects);
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewSubjects.jsp");
		rd.forward(request, response);
		session.close();
	}
}
