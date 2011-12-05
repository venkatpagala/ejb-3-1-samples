package com.sample.ejb3.aspects;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogTimeInterceptor {

	@AroundInvoke
	/**
	 * Observation: If return type is not Object this interceptor will not be invoked.
	 */
	public Object logTimeTaken(InvocationContext invocationCtx) {
		Object obj = null;
		long startTime = System.currentTimeMillis();
		System.out.println(this.getClass().getSimpleName() + " invoked.");
		try {
			obj = invocationCtx.proceed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Got exception :" + e.getMessage());
			
		}

		System.out.println(invocationCtx.getMethod().getName()
				+ "()  took time: " + (System.currentTimeMillis() - startTime));

		return obj;

	}
}
