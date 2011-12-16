package com.sample.ejb3.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

//@Entity
//@Table(name="billing_details")
//@SecondaryTable(name="employee")
public class Billing {

	@Id
	@Column(name = "billing_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BillingCompositePK id;

	@Column(name = "per_hour_billing", nullable = false)
	private Float billingRate;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@Column(name = "is_contractor")
	private Boolean isContractor;

	@Column(name = "contractor_name")
	private Long contractorName;

	//@OneToOne
	//@JoinColumn(name = "emp_id")
	//private Employee employeeDetails;

	public BillingCompositePK getId() {
		return id;
	}

	public void setId(BillingCompositePK id) {
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

	public Long getContractorName() {
		return contractorName;
	}

	public void setContractorName(Long contractorName) {
		this.contractorName = contractorName;
	}

/*	public Employee getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(Employee employeeDetails) {
		this.employeeDetails = employeeDetails;
	}*/

}
