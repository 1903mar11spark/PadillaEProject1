package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//grab current session, if it exists
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			//response.setContentType("application/json");
				
			String username = session.getAttribute("username").toString();
			String firstname = session.getAttribute("firstname").toString();
			String lastname = session.getAttribute("lastname").toString();
			String password = session.getAttribute("password").toString();
			int emplId = Integer.parseInt(session.getAttribute("emplId").toString());
			int managId = Integer.parseInt(session.getAttribute("managerId").toString());
				
			Employee empl = new Employee(emplId, firstname,lastname, username, password, managId);
			
			ObjectMapper om = new ObjectMapper();
			String emplString = om.writeValueAsString(empl);
			response.getWriter().write("{\"user\":"+emplString+"}");
				
			} else {
				response.setContentType("application/json");
				response.getWriter().write("{\"session\":null}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
