package com.sample.ejb3.slsb.simple;

import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.ejb3.annotation.Pool;

import com.sample.ejb3.Constants;
import com.sample.ejb3.aspects.LogTimeInterceptor;
import com.sample.ejb3.session.exception.ResourceNotFoundAppException;
import com.sample.ejb3.session.exception.ResourceNotFoundSystemException;
import com.sample.ejb3.slsb.simple2.Worker;

@Stateless(name = "ABCBean")
@Remote(SimpleStatelessBusinessRemote.class)
@Local(SimpleStatelessBusinessLocal.class)
@Pool(maxSize = 3)
@Interceptors(LogTimeInterceptor.class)
public class SimpleStatelessBase implements SimpleStatelessBusinessRemote,
		SimpleStatelessBusinessLocal {

	@Resource
	private SessionContext context;

	private InitialContext initCtx;

	@PostConstruct
	private void init() {
		try {
			initCtx = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (initCtx != null)
			System.out.println("Resources initialized.");
		else
			System.out.println("Failed to initialize resources.");
	}

	public String sayHello(String message) {
		return "Hello " + message;
	}

	@Override
	public Boolean hasAppResource() {
		throw new ResourceNotFoundAppException(
				"Details of Application Exception");
	}

	@Override
	public Boolean hasSysResource() {
		throw new ResourceNotFoundSystemException("Details of System Exception");
	}

	@Override
	public void passRefToWorker() {
		try {
			Worker workerBean = (Worker) initCtx
					.lookup(Constants.BUSINESS_REMOTE_WORKER);
			System.out.println("workerBean " + workerBean);
			SimpleStatelessBusinessRemote slsbRemoteRef = context
					.getBusinessObject(SimpleStatelessBusinessRemote.class);

			System.out.println("slsbRemoteRef " + slsbRemoteRef);
			workerBean.useSLSB(slsbRemoteRef);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PreDestroy
	private void cleanup() {
		initCtx = null;
		System.out.println("Resources released.");
	}

	@Override
	@Asynchronous
	public Future<String> printwithDelay() {
		// int counter = 0;
		System.out.println("Starting Async method call printwithDelay.");
		Double val = 0.0;

		// while (counter++ < 2)
		val = Math.cosh(2.33);

		System.out.println("Val: " + val);

		return new AsyncResult<String>("Completed");
	}

}
