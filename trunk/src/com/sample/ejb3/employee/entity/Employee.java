package com.sample.ejb3.employee.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "employee")
//@SecondaryTable(name="organization")
public class Employee implements Serializable{

	@Id
	@Column(name = "emp_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;

	@Column(name = "middle_name", length = 100)
	private String middleName;

	@Column(name = "last_name", length = 45)
	private String lastName;

	@Column(name = "age", nullable = false)
	private Integer biologicalAge;

	@Column(name = "joining_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar joiningDate;

	@OneToOne
	@JoinColumn(name="billing_id")
	private Billing billingD;
	
/*
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "org_id")
	private Organization employer;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Billing getBillingD() {
		return billingD;
	}

	public void setBillingD(Billing billingD) {
		this.billingD = billingD;
	}



	@Transient
	private Integer percentAgeInOrg;

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getBiologicalAge() {
		return biologicalAge;
	}

	public void setBiologicalAge(Integer biologicalAge) {
		this.biologicalAge = biologicalAge;
	}

	public Calendar getJoiningDate() {
		return joiningDate;
	}

	public Integer getPercentAgeInOrg() {
		setPercentAgeInOrg(((biologicalAge - (Calendar.getInstance().get(
				Calendar.YEAR) - joiningDate.get(Calendar.YEAR))) / biologicalAge) * 100);
		return percentAgeInOrg;
	}

	public void setPercentAgeInOrg(Integer percentAgeInOrg) {
		this.percentAgeInOrg = percentAgeInOrg;
	}
	

	
/*
	public Organization getEmployer() {
		return employer;
	}

	public void setEmployer(Organization employer) {
		this.employer = employer;
	}*/

	public void setJoiningDate(Calendar joiningDate) {
		this.joiningDate = joiningDate;
	}

}
