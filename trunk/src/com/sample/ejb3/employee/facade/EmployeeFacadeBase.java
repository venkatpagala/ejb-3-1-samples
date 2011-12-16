package com.sample.ejb3.employee.facade;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.Pool;

import com.sample.ejb3.employee.entity.Employee;

@Stateless(name = "EmployeeBean")
@Remote(EmployeeFacadeRemote.class)
@Local(EmployeeFacadeLocal.class)
@Pool(maxSize = 2, timeout = 2000)
public class EmployeeFacadeBase implements EmployeeFacadeLocal,
		EmployeeFacadeRemote {

	@PersistenceContext(unitName="org")
	private EntityManager entityManager;

	@Override
	public Employee add(String firstName, String middleName, String lastName,
			Integer age, Calendar joinDate) {
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setMiddleName(middleName);
		emp.setLastName(lastName);
		emp.setBiologicalAge(age);
		emp.setJoiningDate(joinDate);
		entityManager.persist(emp);
		
		return emp;
	}

	@Override
	public void remove(Long empId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee get(Long empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findMatching(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee update(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
