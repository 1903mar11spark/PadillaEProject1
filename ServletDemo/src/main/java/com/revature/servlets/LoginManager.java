package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAOImpl;

/**
 * Servlet implementation class LoginManager
 */
public class LoginManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("managerLogin.html").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession();
			EmployeeDAOImpl emplDAO = new EmployeeDAOImpl();
			Employee empl = null;
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			empl = emplDAO.getEmployeebyCredentials(username, password);
			
			
			
			System.out.println(empl+ " here i am");
			int emplId = empl.getId();
			System.out.println(emplId);
			int manId = empl.getManagerId();
			System.out.println(manId);
			
			if(empl != null && emplId == manId) {
				session.setAttribute("username", empl.getUserName());
				session.setAttribute("firstname", empl.getFirstName());
				session.setAttribute("lastname", empl.getLastName());
				session.setAttribute("password", empl.getPassWord());
				session.setAttribute("emplId", empl.getId());
				session.setAttribute("managerId", empl.getManagerId());
				session.setAttribute("problem", null);
				response.sendRedirect("manager");
			} else {
				session.setAttribute("problem", "invalid credentials");
				//otherwise redirect to login page
				response.sendRedirect("loginManager");
			}
		
	}

}
