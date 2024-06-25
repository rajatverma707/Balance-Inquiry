package com.balanceenquiry.exception;


public class AccountNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String exception){
		super(exception);
	}
	
}
