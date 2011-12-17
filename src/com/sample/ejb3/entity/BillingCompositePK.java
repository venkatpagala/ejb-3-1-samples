package com.sample.ejb3.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BillingCompositePK implements Serializable {

	/**
	 * Generated Ser. Ver. Id
	 */
	private static final long serialVersionUID = 6873308809857530705L;

	@Column(name = "emp_id", nullable = false)
	private Long employeeId;

	@Column
	private Long orgId;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		BillingCompositePK billingPK = (BillingCompositePK) obj;
		if (employeeId == null) {
			if (billingPK.getEmployeeId() != null)
				return false;
			else if (employeeId != billingPK.getEmployeeId())
				return false;
		}
		if (orgId == null) {
			if (billingPK.getOrgId() != null)
				return false;
			else if (orgId != billingPK.getOrgId())
				return false;
		}

		return true;
	}

}
