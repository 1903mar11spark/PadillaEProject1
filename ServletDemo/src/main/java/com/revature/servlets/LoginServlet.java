package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check whether session exists, and create one if not
		//overloaded version takes a boolean parameter, 
		//if false returns null when there is none
		
		HttpSession session = request.getSession();
		//response.setContentType("text/html");
		
		Employee empl = null;
		EmployeeDAOImpl emplDAO = new EmployeeDAOImpl();

		
		//grab credentials from request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		empl = emplDAO.getEmployeebyCredentials(username, password);
		
			if(empl != null) {
				session.setAttribute("username", empl.getUserName());
				session.setAttribute("firstname", empl.getFirstName());
				session.setAttribute("lastname", empl.getLastName());
				session.setAttribute("password", empl.getPassWord());
				session.setAttribute("emplId", empl.getId());
				session.setAttribute("managerId", empl.getManagerId());
				session.setAttribute("problem", null);
				response.sendRedirect("Profile");
			} else {
				session.setAttribute("problem", "invalid credentials");
				//otherwise redirect to login page
				response.sendRedirect("login");
			}
		
	}

}
