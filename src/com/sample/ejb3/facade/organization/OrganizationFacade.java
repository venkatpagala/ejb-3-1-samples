package com.sample.ejb3.facade.organization;

import java.util.List;

import com.sample.ejb3.entity.Organization;

public interface OrganizationFacade {

	Organization add(String shortName, String registeredName, String city,
			String state, String country);

	List<Organization> getOrgsWithUnderageEmployees();

}
