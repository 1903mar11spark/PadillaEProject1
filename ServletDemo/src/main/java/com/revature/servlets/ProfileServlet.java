package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		request.getRequestDispatcher("profile.html").forward(request, response);
		
		//check if session exists
//		if(session != null && session.getAttribute("userName") != null) {
//
//			request.getRequestDispatcher("profile.html").forward(request, response);
//		} else {
//			response.sendRedirect("login");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String fValue = request.getParameter("firstInput").toString();
		String sValue = request.getParameter("secondInput").toString();
		String tValue = request.getParameter("thirdInput").toString();
		
        //String sessionFullName = session.getAttribute("firstname") + " " + session.getAttribute("lastname");

        EmployeeDAO emplDao = new EmployeeDAOImpl();

        if(fValue.equals(session.getAttribute("userName"))) {
        	if(sValue.equals(tValue)) {
        	
        			
        		emplDao.updateEmpUsername((int) session.getAttribute("id"), sValue);
        		session.setAttribute("userName", sValue);
        	
        	}
        	
        }
		doGet(request, response);
	}

}
