package com.sample.ejb3.slsb.simple;

import java.util.concurrent.Future;

public interface SimpleStateless {

	String sayHello(String message);
	
	Boolean hasAppResource();
	Boolean hasSysResource();
	
	void passRefToWorker();
	
	Future<String> printwithDelay();

}
