package com.sample.ejb3.slsb.simple2;

import com.sample.ejb3.slsb.simple.SimpleStateless;

public interface Worker {

	void useSLSB(SimpleStateless otherEJB);
	
	Long filter(Long input);
	
	

}
