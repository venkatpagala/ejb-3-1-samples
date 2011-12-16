package com.sample.ejb3.employee.facade;

import java.util.Calendar;
import java.util.List;

import com.sample.ejb3.employee.entity.Employee;

public interface EmployeeFacade {

	Employee add(String firstName, String middleName, String lastName, Integer age, Calendar joinDate );

	void remove(Long empId);

	Employee get(Long empId);

	List<Employee> findMatching(Employee emp);

	Employee update(Employee emp);

}
