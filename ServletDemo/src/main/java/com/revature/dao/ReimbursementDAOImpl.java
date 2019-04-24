package com.revature.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public boolean createReimbursement(int employeeId, int managerId, String purpose, double amount) {
		//Reimbursement reim = new Reimbursement();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "INSERT INTO REIMBURSEMENT(EMPLOYEE_ID, AMOUNT, MANAGER_ID, PURPOSE) VALUES(?,?,?,?)";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the first '?' to the value of 'id' 
			pstmt.setInt(1, employeeId);
			pstmt.setDouble(2, amount);
			pstmt.setDouble(3, managerId);
			pstmt.setString(4, purpose);
		
			
			pstmt.execute();
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return true;

	}

	@Override
	public List<Reimbursement> getManReimbursements() {
		
		
		return null;
	}

	@Override
	public Reimbursement updateStatus(int status, int reimId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getEmplReimbursements(int emplId) {
		
		List<Reimbursement> reim = new ArrayList<Reimbursement>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
		
			String sql = "SELECT R.REIM_ID, R.EMPLOYEE_ID, R.MANAGER_ID, E.FIRSTNAME, "
					+ "E.LASTNAME, R.STATUS, R.AMOUNT, R.PURPOSE "
					+ "FROM REIMBURSEMENT R "
					+ "INNER JOIN EMPLOYEE E "
					+ "ON R.EMPLOYEE_ID = E.EMPLOYEE_ID "
					+ "WHERE R.EMPLOYEE_ID = ?";
			
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, emplId);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			int reimId = rs.getInt("REIM_ID");
			int employeeId = rs.getInt("EMPLOYEE_ID");
			int managerId = rs.getInt("MANAGER_ID");
			String firstname = rs.getString("FIRSTNAME");
			String lastname = rs.getString("LASTNAME");
			int status = rs.getInt("STATUS");
			double amount = rs.getDouble("AMOUNT");
			String purpose = rs.getString("PURPOSE");
		
			
			reim.add(new Reimbursement(reimId, employeeId, managerId, firstname, lastname, status, amount,purpose));
		
		}
	} catch (SQLException | IOException e) {
		
		e.printStackTrace();
	}
		return reim;
	}

	@Override
	public Reimbursement updateAmount(int reimId, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
