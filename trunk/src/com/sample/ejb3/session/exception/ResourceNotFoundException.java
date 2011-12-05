package com.sample.ejb3.session.exception;

/**
 * This is a type of @RuntimeException, so no declaration needed in method
 * signature.
 * 
 * @author Nishant.Agrawal
 * 
 */
public class ResourceNotFoundException extends RuntimeException {

	private String message;

	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException(String message) {
		this.message = message;
	}

}
