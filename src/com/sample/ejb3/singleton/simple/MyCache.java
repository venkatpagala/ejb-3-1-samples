package com.sample.ejb3.singleton.simple;

import java.util.List;

/**
 * Objectives:
 * 1. Implement Cache using Singleton.
 * 2. Avoid dirty reads by implementing WRITE and READ locks.
 * 3. Start Cache during deployment.
 * 4. Return immutable values.
 * 
 * @author Nishant.Agrawal
 * 
 */
public interface MyCache {
	
	String getResource(Integer index);
	
	// Set Position = -1 to add value;
	String updateResource(Integer position, String value);
	
	List<String> getList(); 
	
	

}
