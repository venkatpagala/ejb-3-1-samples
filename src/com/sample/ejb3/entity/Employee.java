package com.sample.ejb3.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "employee")
// @SecondaryTable(name="organization")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8056295724630115370L;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, String name) {
		this.id = id;
		this.firstName = name;
	}

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
	@JoinColumn(name = "billing_id")
	private Billing billing;

	@ManyToOne
	@JoinColumn(name = "org_id")
	private Organization employer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
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

	public void setJoiningDate(Calendar joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Organization getEmployer() {
		return employer;
	}

	public void setEmployer(Organization employer) {
		this.employer = employer;
	}

}
