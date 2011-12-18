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

import com.sample.ejb3.entity.EmployeePrimary;
import com.sample.ejb3.entity.EmployeeSecondary;

@Stateless(name = "EmployeeBean")
@Remote(EmployeeFacadeRemote.class)
@Local(EmployeeFacadeLocal.class)
@Pool(maxSize = 2, timeout = 2000)
public class EmployeeFacadeBase implements EmployeeFacadeLocal,
		EmployeeFacadeRemote {

	@PersistenceContext(unitName = "org")
	private EntityManager entityManager;

	@Override
	public EmployeePrimary add(String firstName, String middleName,
			String lastName, Integer age, Calendar joinDate) {
		EmployeePrimary emp = new EmployeePrimary();
		emp.setFirstName(firstName);
		emp.setMiddleName(middleName);
		emp.setLastName(lastName);
		emp.setBiologicalAge(age);
		emp.setJoiningDate(joinDate);

		entityManager.persist(emp);
		EmployeeSecondary empSecDetails = new EmployeeSecondary(
				(Math.random() * 10) >= 5 ? Boolean.TRUE : Boolean.FALSE);
		empSecDetails.setEmployeeprimary(emp);

		entityManager.persist(empSecDetails);

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
			EmployeePrimary emp = entityManager.find(EmployeePrimary.class,
					empId);

			entityManager.remove(emp);

			System.out
					.println("-- DELETED employee " + emp.getId() + ", Name: "
							+ emp.getFirstName() + " " + emp.getLastName());
		} else {
			System.out.println("Wrong Input: employee id is null ");
		}
	}

	@Override
	public EmployeePrimary get(Long empId) {

		return entityManager.find(EmployeePrimary.class, empId);
	}

	@Override
	public void updateName(Long empId, String newName) {
		entityManager.merge(new EmployeePrimary(empId, newName, 19));
		System.out.println("Name of employee updated. Id: " + empId);
		return;
	}

	@Override
	public void removeAll() {

		entityManager.createQuery("delete from Employee e").executeUpdate();
		System.out.println("all Employees DELETED.");

	}

	@Override
	public List<EmployeePrimary> findByName(String name) {
		String matchingNameQuery = "select e FROM "
				+ EmployeePrimary.class.getSimpleName()
				+ " e where lower(e.firstName) = :fname";

		Query query = entityManager.createQuery(matchingNameQuery)
				.setParameter("fname", "firstname").setMaxResults(100);
		;

		return query.getResultList();
	}

}
