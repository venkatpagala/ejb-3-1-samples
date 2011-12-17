package com.sample.ejb3.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;

//@Entity
public class Billing_NotUsedNow {

	@EmbeddedId
	@AttributeOverrides(
			{
				@AttributeOverride(
						name = "orgId",
						column = @Column(name = "org_id", nullable = false)) }
			)
	private BillingCompositePK id;
	
	@Column(name = "per_hour_billing", nullable=false)
	private Float billingRate;
	
	@Column(name="is_enabled", nullable=false)
	private Boolean isEnabled;
	
	@Column(name="is_contractor")
	private Boolean isContractor;
	
	@Column(name="contractor_id")
	private Long contractorId;

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

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Boolean getIsContractor() {
		return isContractor;
	}

	public void setIsContractor(Boolean isContractor) {
		this.isContractor = isContractor;
	}

	public Long getContractorId() {
		return contractorId;
	}

	public void setContractorId(Long contractorId) {
		this.contractorId = contractorId;
	}
	

}
