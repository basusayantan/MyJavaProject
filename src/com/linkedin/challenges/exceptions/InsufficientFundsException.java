package com.linkedin.challenges.exceptions;

public class InsufficientFundsException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public InsufficientFundsException() {
		//null constructor
	}
	public InsufficientFundsException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
