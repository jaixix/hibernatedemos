package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.Book;
import util.HibernateUtil;


@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		String isbn = request.getParameter("isbn");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Book book = new Book(isbn, bookName,price);
		
		session.save(book);
		
		session.getTransaction().commit();
		
		session.close();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Book Added</h1>");
		out.println("<a href='BookStore.html'>Home</a>");
	}
}