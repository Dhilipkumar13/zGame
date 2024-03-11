package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Connector.LogPage;

/**
 * Servlet implementation class Servlet_login
 */
public class Servlet_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String in_mail1=request.getParameter("in_name");
				String in_pass1=request.getParameter("in_password");
				String in_mail2=request.getParameter("in_name_2");
				String in_pass2=request.getParameter("in_password_2");
				PrintWriter a=response.getWriter();
				LogPage log=new LogPage(in_mail1,in_pass1);
				LogPage log2=new LogPage(in_mail2,in_pass2);	
				if (log.signin() && log2.signin()){
				    // If login is successful, forward the request to another resource (e.g., a welcome page)
				    RequestDispatcher dispatcher = request.getRequestDispatcher("tic-tac-toe.html"); // Replace "/welcome.jsp" with the appropriate path or URL
				    dispatcher.forward(request, response);
				} else {
				    // If login fails, print an error message
				    a.println("Login Fail...!!!");
				    a.print("Check your Username or Password");

				    // You can also redirect to a different page if needed
				    // response.sendRedirect("/login.jsp"); // Replace "/login.jsp" with the appropriate path or URL
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
