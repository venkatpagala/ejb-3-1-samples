package com.sample.ejb3.employee.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "org_employee")
public class Employee {

	@Id
	@Column(name = "emp_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;

	@Column(name = "middle_name", length = 100)
	private String middleName;

	@Column(name = "last_city", length = 45)
	private String lastName;

	@Column(name = "age", nullable = false)
	private Integer biologicalAge;

	@Column(name = "joining_date", nullable = false)
	private Calendar joiningDate;

	@Transient
	private Integer percentAgeInOrg;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

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

}
