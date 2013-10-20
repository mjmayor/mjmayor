package org.mjmayor.jpa.facade;

import javax.persistence.criteria.CriteriaBuilder;

import org.mjmayor.jpa.service.Service;

public abstract class Facade {

	protected CriteriaBuilder criteriaBuilder;

	public Facade(Service<?, ?> service) {
		this.criteriaBuilder = service.getCriteriaBuilder();
	}
}
