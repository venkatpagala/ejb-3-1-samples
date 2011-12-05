package com.sample.ejb3.slsb.simple2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;

import com.sample.ejb3.Constants;
import com.sample.ejb3.slsb.simple.SimpleStateless;

public class WorkerBase implements WorkerBusinessRemote, WorkerBusinessLocal {

	@Resource
	private SessionContext sessCtx;

	@PostConstruct
	private void init() {
		System.out.println("Resources initialized.");
	}

	@PreDestroy
	private void cleanup() {
		System.out.println("Resources released.");
	}

	@Override
	public void useSLSB(SimpleStateless otherEJB) {
		System.out
				.println("Will call SimpleStatess though passed Remote Reference.");
		System.out.println(otherEJB.sayHello("WorkerBase"));

	}

	@Override
	public Long filter(Long input) {
		Long filterVal = Long.class.cast(sessCtx
				.lookup(Constants.ENV_FILTER_NAME_FILTER));
		return (filterVal & input);

	}

}
