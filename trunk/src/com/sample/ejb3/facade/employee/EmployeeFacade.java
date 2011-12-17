package com.sample.ejb3.facade.employee;

import java.util.Calendar;
import java.util.List;

import com.sample.ejb3.entity.Employee;

public interface EmployeeFacade {

	Employee add(String firstName, String middleName, String lastName, Integer age, Calendar joinDate );

	void remove(Long empId);
	
	void removeAll();

	Employee get(Long empId);

	List<Employee> findByName(String name);

	Employee update(Employee emp);

}
