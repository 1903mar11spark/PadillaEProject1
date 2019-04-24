package com.revature.exceptions;

public class UsernameExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsernameExistsException() {
		super("Must provide a valid username please!");
		
	}
	
	public String getMessage() {
		return super.getMessage();
	}

}
