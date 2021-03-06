package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAOImpl;

/**
 * Servlet implementation class CreateReimbursement
 */
public class CreateReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReimbursement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		
		if (session != null && session.getAttribute("username") != null) {
			
			request.getRequestDispatcher("profile.html").forward(request, response);
			
		} else {
			response.sendRedirect("login");
			
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		ReimbursementDAOImpl reimDAO = new ReimbursementDAOImpl();
		
		String purpose = request.getParameter("purpose");
		Double amount = Double.valueOf(request.getParameter("amount").toString());
		
		
		int employeeId = (int) session.getAttribute("emplId");
		int managerId = (int) session.getAttribute("managerId");
		
		reimDAO.createReimbursement(employeeId,managerId,purpose, amount);
				
		doGet(request, response);
	}

}
