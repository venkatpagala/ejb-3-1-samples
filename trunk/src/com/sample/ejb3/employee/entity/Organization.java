package com.sample.ejb3.employee.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "org_organization")
public class Organization {

	@Id
	@Column(name = "org_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orgId;

	@Column(name = "short_name", nullable = false, length = 45)
	private String name;

	@Column(name = "registered_name", length = 100)
	private String legalName;

	@Column(name = "address_city", length = 45)
	private String city;

	@Column(name = "address_state", length = 45)
	private String state;

	@Column(name = "address_country", length = 45)
	private String country;

	@OneToMany(mappedBy = "employer")
	private Collection<Employee> employees;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}

}
