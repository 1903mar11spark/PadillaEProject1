package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.exceptions.UsernameExistsException;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get current session 
		HttpSession session = request.getSession(false);
		
		//check if session exists
		if(session != null && session.getAttribute("username") != null) {

			request.getRequestDispatcher("profile.html").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("emplId"));
		String newUsername = request.getParameter("newUsername").toString();
		String newPassword = request.getParameter("newPassword").toString();
				
		System.out.println(newUsername);
     	System.out.println(newPassword);
     	

        EmployeeDAO emplDao = new EmployeeDAOImpl();
        Employee empl = new Employee();

        	if(newUsername != null) {
        		emplDao.updateEmpUsername((int)session.getAttribute("emplId"), newUsername);
        		session.setAttribute("username", newUsername);
        	}
        	if(newPassword != null) {
        		
        		emplDao.updateEmpPassword((int) session.getAttribute("emplId"), newPassword);
        		session.setAttribute("username", empl.getUserName());
        		session.setAttribute("password", newPassword);
        	}
        	System.out.println(session.getAttribute(newUsername));
		doGet(request, response);
	}
	
}
