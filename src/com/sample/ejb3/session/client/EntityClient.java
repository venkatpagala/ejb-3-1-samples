package com.sample.ejb3.session.client;

import java.util.GregorianCalendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sample.ejb3.Constants;
import com.sample.ejb3.employee.facade.EmployeeFacade;

public class EntityClient {

	private static InitialContext ctx;

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		EmployeeFacade employeeBean;
		
		 ctx = new InitialContext();
		try {
			employeeBean = (EmployeeFacade) ctx
					.lookup(Constants.BUSINESS_REMOTE_EMPLOYEE);

			System.out.println("Value "
					+ employeeBean.add("firstName", "middleName", "lastName",
							25, GregorianCalendar.getInstance()));

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
