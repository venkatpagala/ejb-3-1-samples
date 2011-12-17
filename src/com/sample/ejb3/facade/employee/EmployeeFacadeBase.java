package com.sample.ejb3.facade.employee;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Pool;

import com.sample.ejb3.entity.Employee;

@Stateless(name = "EmployeeBean")
@Remote(EmployeeFacadeRemote.class)
@Local(EmployeeFacadeLocal.class)
@Pool(maxSize = 2, timeout = 2000)
public class EmployeeFacadeBase implements EmployeeFacadeLocal,
		EmployeeFacadeRemote {

	@PersistenceContext(unitName = "org")
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

		/*
		 * Billing billn = new Billing(); billn.setBillingRate(89.0f);
		 * billn.setContractorName("contractorName");
		 * 
		 * billn.setEmployee(emp); emp.setBilling(billn);
		 * entityManager.persist(billn);
		 * 
		 * Organization org = new Organization(); org.setName("Organization");
		 * emp.setEmployer(org); entityManager.persist(org);
		 * 
		 * Organization org2 = entityManager.find(Organization.class, new
		 * Long(6)); Iterator OrgIter = org2.getEmployees().iterator();
		 * System.out.println(((Employee) OrgIter.next()).getFirstName());
		 */
		return emp;
	}

	@Override
	public void remove(Long empId) {
		if (empId != null) {
			Employee emp = entityManager.find(Employee.class, empId);

			entityManager.remove(emp);

			System.out
					.println("-- DELETED employee " + emp.getId() + ", Name: "
							+ emp.getFirstName() + " " + emp.getLastName());
		} else {
			System.out.println("Wrong Input: employee id is null ");
		}
	}

	@Override
	public Employee get(Long empId) {

		return entityManager.find(Employee.class, empId);
	}

	@Override
	public Employee update(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {

		entityManager.createQuery("delete from Employee e").executeUpdate();
		System.out.println("all Employees DELETED.");

	}

	@Override
	public List<Employee> findByName(String name) {
		String matchingNameQuery = "select e FROM "
				+ Employee.class.getSimpleName()
				+ " e where lower(e.firstName) = :fname";

		Query query = entityManager.createQuery(matchingNameQuery)
				.setParameter("fname", "firstname").setMaxResults(100);
		;

		return query.getResultList();
	}

}
