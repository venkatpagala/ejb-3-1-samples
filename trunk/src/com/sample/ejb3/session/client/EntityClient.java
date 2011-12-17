package com.sample.ejb3.session.client;

import java.util.GregorianCalendar;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sample.ejb3.Constants;
import com.sample.ejb3.entity.Employee;
import com.sample.ejb3.entity.Organization;
import com.sample.ejb3.facade.employee.EmployeeFacade;
import com.sample.ejb3.facade.organization.OrganizationFacade;

public class EntityClient {

	private static InitialContext ctx;

	private EmployeeFacade employeeBean;

	private OrganizationFacade organizationBean;

	public EntityClient() {
		try {

			ctx = new InitialContext();
			employeeBean = (EmployeeFacade) ctx
					.lookup(Constants.BUSINESS_REMOTE_EMPLOYEE);

			organizationBean = (OrganizationFacade) ctx
					.lookup(Constants.BUSINESS_REMOTE_ORGANIZATION);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @throws NamingException
	 */
	public static void main(String[] args) throws NamingException {
		EntityClient client = new EntityClient();
		//client.removeAllEmployees();

		Employee emp = client.createEmployee();
		emp = client.createEmployee();
		//client.removeEmployee(new Employee(emp.getId() - 1, "null"));
		List<Employee> employeesInResult = client.findEmployeesByName("ame");
		// for (Employee e : employeesInResult)
		// System.out.println("Found emp: " + e.getFirstName());

		List<Organization> orgs = client.getOrgsWithChildLabor();

		System.out.println(orgs.get(0).getName() + orgs.get(0).getOrgId());

		for (Organization o : orgs)
			System.out.println("Found Org with child labors: " + o.getOrgId()
					+ ", Name" + o.getName());

	}

	private List<Organization> getOrgsWithChildLabor() {
		return organizationBean.getOrgsWithUnderageEmployees();
	}

	public Employee createEmployee() {

		return employeeBean.add("firstName", "middleName", "lastName", 25,
				GregorianCalendar.getInstance());
	}

	public void removeEmployee(Employee emp) {
		employeeBean.remove(emp.getId());

	}

	public void removeAllEmployees() {
		employeeBean.removeAll();
	}

	public List<Employee> findEmployeesByName(String name) {
		return employeeBean.findByName(name);
	}
}
