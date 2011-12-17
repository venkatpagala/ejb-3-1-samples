package com.sample.ejb3.facade.organization;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Pool;

import com.sample.ejb3.entity.Organization;

@Stateless(name = "OrganizationBean")
@Remote(OrganizationFacadeRemote.class)
@Local(OrganizationFacadeLocal.class)
@Pool(maxSize = 2, timeout = 2000)
public class OrganizationFacadeBase implements OrganizationFacadeLocal,
		OrganizationFacadeRemote {

	@PersistenceContext(unitName = "org")
	private EntityManager entityManager;

	/*
	 * @Override public List<Employee> findByName(String name) { String
	 * matchingNameQuery = "select e FROM " + Employee.class.getSimpleName() +
	 * " e where lower(e.firstName) = :fname";
	 * 
	 * Query query = entityManager.createQuery(matchingNameQuery)
	 * .setParameter("fname", "firstname").setMaxResults(100); ;
	 * 
	 * return query.getResultList(); }
	 */

	@Override
	public Organization add(String shortName, String registeredName,
			String city, String state, String country) {
		Organization org = new Organization();
		Integer rnd = Double.class.cast((Math.random() * 10.0)).intValue();
		org.setName("Org" + rnd);
		org.setCity("city" + rnd);
		org.setState("state" + rnd);
		org.setCountry("country" + rnd);
		entityManager.persist(org);
		return org;
	}

	@Override
	public List<Organization> getOrgsWithUnderageEmployees() {
		String matchingNameQuery = "select o FROM "
				+ Organization.class.getSimpleName()
				+ " AS o, IN(o.employees) e where e.biologicalAge < 18";
		Query query = entityManager.createQuery(matchingNameQuery)
				.setMaxResults(100);

		return query.getResultList();
	}

}
