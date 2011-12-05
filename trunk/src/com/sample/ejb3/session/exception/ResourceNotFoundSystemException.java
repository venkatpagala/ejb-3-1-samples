package com.sample.ejb3.session.exception;

public class ResourceNotFoundSystemException extends ResourceNotFoundException {

	private String message;

	public ResourceNotFoundSystemException() {
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundSystemException(String message) {
		this.message = message;
	}

}
