package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

/**
 * Servlet implementation class ViewReimbursements
 */
public class ViewReimbursements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReimbursements() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		ReimbursementDAO reim = new ReimbursementDAOImpl();
		List<Reimbursement> reimList = null;
		
		int emplId = (int) session.getAttribute("emplId");
		
		//int manaId = (int) session.getAttribute("managerId");
		
		reimList = reim.getEmplReimbursements(emplId);
		
		ObjectMapper om = new ObjectMapper();
		String reimString = om.writeValueAsString(reimList);
		response.getWriter().write("{\"reimbursements\":"+reimString+"}");
		System.out.println(reimList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
