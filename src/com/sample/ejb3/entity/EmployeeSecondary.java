package com.sample.ejb3.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee_secondary")
@org.hibernate.annotations.GenericGenerator(name = "employeeprimary-primarykey", strategy = "foreign", parameters = { @org.hibernate.annotations.Parameter(name = "property", value = "employeeprimary") })
public class EmployeeSecondary implements Serializable {

	@Id
	@Column(name = "emp_id", nullable = false)
	@GeneratedValue(generator = "employeeprimary-primarykey")
	private Long id;

	@Column(name = "is_married")
	private Boolean isMarried = Boolean.FALSE;

	@OneToOne
	@PrimaryKeyJoinColumn
	private EmployeePrimary employeeprimary;

	public EmployeeSecondary() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeSecondary(Boolean isMarried) {
		this.isMarried = isMarried;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeePrimary getEmployeeprimary() {
		return employeeprimary;
	}

	public void setEmployeeprimary(EmployeePrimary employeeprimary) {
		this.employeeprimary = employeeprimary;
	}

	public Boolean getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(Boolean isMarried) {
		this.isMarried = isMarried;
	}

}
