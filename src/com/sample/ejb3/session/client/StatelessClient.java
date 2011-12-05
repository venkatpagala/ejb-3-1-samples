package com.sample.ejb3.session.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sample.ejb3.Constants;
import com.sample.ejb3.session.exception.ResourceNotFoundException;
import com.sample.ejb3.slsb.simple.SimpleStateless;
import com.sample.ejb3.slsb.simple2.Worker;

public class StatelessClient {

	private static InitialContext ctx;

	public static void main(String[] args) throws Exception {

		ctx = new InitialContext();
		callSimpleStateless();
		callWorker();

	}

	private static void callWorker() {
		long inputValue = 5;
		try {
			Worker workerBean = (Worker) ctx
					.lookup(Constants.BUSINESS_REMOTE_WORKER);
			System.out.println("Value " + inputValue + " filtered to "
					+ workerBean.filter(inputValue));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void callSimpleStateless() throws NamingException {

		SimpleStateless simpleStatelessBean = (SimpleStateless) ctx
				.lookup(Constants.BUSINESS_REMOTE_SIMPLE);

		final Future<String> retValue = simpleStatelessBean.printwithDelay();

		System.out.println(simpleStatelessBean.sayHello("someone"));
		try {
			System.out.println("Call to hasAppResource.");
			simpleStatelessBean.hasAppResource();

		} catch (ResourceNotFoundException e) {
			System.out.println(e.getClass());
		}

		try {
			System.out.println("Call to hasSysResource.");

			simpleStatelessBean.hasSysResource();

		} catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage().substring(0, 100));
		}

		simpleStatelessBean.passRefToWorker();

		try {
			System.out.println(retValue.get(100, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
