package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.exceptions.UsernameTakenException;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	public Employee getEmployeebyCredentials(String username, String password) {

		Employee employee = new Employee();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ? AND"
					+ " PASS_WORD = ?";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the '?' to the value of parameters 
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int emp = rs.getInt("EMPLOYEE_ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String user = rs.getString("USERNAME");
				String pass = rs.getString("PASS_WORD");
				int manId = rs.getInt("MANAGER_ID");
				employee = new Employee(emp, firstname, lastname, user,pass,manId);
				
				
				

			}
			
	} catch (SQLException | IOException e){
		e.printStackTrace();
	}
		return employee;
	}



	public Employee getEmployeeById(int id) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			
			String sql = "SELECT EMPLOYEE_ID FROM EMPLOYEE";
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateEmpUsername(int empId, String username) {
		String str = "Username updated to" + username; 
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			
			String sql = "UPDATE EMPLOYEE SET USERNAME = ? "
					+ "WHERE EMPLOYEE_ID = ?";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the '?' to the value of parameters 
			pstmt.setString(1, username);
			pstmt.setInt(2, empId);
			
			pstmt.executeUpdate();
			
			con.close();
			
		}catch (SQLIntegrityConstraintViolationException reason ) { 
				str = "Username already exists!";
			}
			catch (SQLException | IOException e) {
				e.printStackTrace();
			}
	
		return str;
	}

	@Override
	public String updateEmpPassword(int empId, String password) {
		String str = "Password updated!"; 

		try(Connection con = ConnectionUtil.getConnectionFromFile()){
		
			String sql = "UPDATE EMPLOYEE SET PASS_WORD = ? "
					+ "WHERE EMPLOYEE_ID = ?";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the '?' to the value of parameters 
			pstmt.setString(1, password);
			pstmt.setInt(2, empId);
			
			pstmt.executeUpdate();
			con.close();
			
		}catch (SQLIntegrityConstraintViolationException reason ) { 
			str = "Username already exists!";
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public Employee deleteEmployee(int empId) {
		
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> reim = new ArrayList<Employee>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
		
			String sql = "SELECT * FROM EMPLOYEE";
			
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			int employeeId = rs.getInt("EMPLOYEE_ID");
			
			String firstname = rs.getString("FIRSTNAME");
			String lastname = rs.getString("LASTNAME");
			int managerId = rs.getInt("MANAGER_ID");
			String username = rs.getString("USERNAME");
			
			reim.add(new Employee(employeeId, firstname, lastname, username, managerId));
		
		}
	} catch (SQLException | IOException e) {
		
		e.printStackTrace();
	}
		
		
		return reim;
	}



	@Override
	public Employee getIsManager(String username) {
		
		Employee employee = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			
			String sql = "SELECT MANAGER_ID, EMPLOYEE_ID FROM EMPLOYEE WHERE USERNAME = ?";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the '?' to the value of parameters 
			pstmt.setString(1, username);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("EMPLOYEE_ID");
				int manId = rs.getInt("MANAGER_ID");
				employee = new Employee(empId, manId);
				
				System.out.println(employee + "dao emp" + "manager id is: "+manId);
			}
			
	} catch (SQLException | IOException e){
		e.printStackTrace();
	}
		
		
		return employee;
	}

}
