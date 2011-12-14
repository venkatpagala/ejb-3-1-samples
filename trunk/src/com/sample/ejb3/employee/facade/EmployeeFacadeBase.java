package com.sample.ejb3.employee.facade;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.Pool;

import com.sample.ejb3.employee.entity.Employee;

@Stateless(name = "EmployeeBean")
@Remote(EmployeeFacadeRemote.class)
@Local(EmployeeFacadeLocal.class)
@Pool(maxSize=2, timeout=200)
public class EmployeeFacadeBase implements EmployeeFacadeLocal,
		EmployeeFacadeRemote {

	@Override
	public Employee add(Employee emp) {
		
		return null;
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
