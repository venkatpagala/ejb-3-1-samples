package com.sample.ejb3.facade.employee;

import java.util.Calendar;
import java.util.List;

import com.sample.ejb3.entity.EmployeePrimary;

public interface EmployeeFacade {

	EmployeePrimary add(String firstName, String middleName, String lastName,
			Integer age, Calendar joinDate);

	void remove(Long empId);

	void removeAll();

	EmployeePrimary get(Long empId);

	List<EmployeePrimary> findByName(String name);

	void updateName(Long empId, String newName);

}
