package com.sample.ejb3.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billing_details")
// @SecondaryTable(name="employee")
public class Billing implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9016404544207943466L;

	@Id
	@Column(name = "billing_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "per_hour_billing", nullable = false)
	private Float billingRate;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@Column(name = "is_contractor")
	private Boolean isContractor;

	@Column(name = "contractor_name")
	private String contractorName;

	@OneToOne(mappedBy = "billing")
	private EmployeePrimary employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getBillingRate() {
		return billingRate;
	}

	public void setBillingRate(Float billingRate) {
		this.billingRate = billingRate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsContractor() {
		return isContractor;
	}

	public void setIsContractor(Boolean isContractor) {
		this.isContractor = isContractor;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public EmployeePrimary getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeePrimary employee) {
		this.employee = employee;
	}

}
