package org.mjmayor.jpa.support.querybuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase para construir consultar genericas
 * 
 * @author Manuel Jose Mayor Perez
 * @date 15/10/2013
 */
public class QueryBuilder<T> {

	private QueryParams<T> queryParams;

	private CriteriaQuery<T> criteriaQuery;

	private Root<T> from;

	public QueryBuilder(QueryParams<T> queryParams) {
		this.queryParams = queryParams;
	}

	public CriteriaQuery<T> query(CriteriaBuilder criteriaBuilder) {
		criteriaQuery = createCriteriaQuery(criteriaBuilder);

		return criteriaQuery;
	}

	private CriteriaQuery<T> createCriteriaQuery(CriteriaBuilder criteriaBuilder) {
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(queryParams.from());
		from = criteriaQuery.from(queryParams.from());
		criteriaQuery.select(from);
		return criteriaQuery;
	}
}
