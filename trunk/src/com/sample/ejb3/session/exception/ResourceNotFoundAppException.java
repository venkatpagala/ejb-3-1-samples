/**
 * 
 */
package com.sample.ejb3.session.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class ResourceNotFoundAppException extends ResourceNotFoundException {

	private String message;

	public ResourceNotFoundAppException() {
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundAppException(String message) {
		this.message = message;
	}

}
