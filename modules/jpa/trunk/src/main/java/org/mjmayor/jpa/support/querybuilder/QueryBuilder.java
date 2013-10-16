package org.mjmayor.jpa.support.querybuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
		setWhere(criteriaBuilder, queryParams.where());
		return criteriaQuery;
	}

	private CriteriaQuery<T> createCriteriaQuery(CriteriaBuilder criteriaBuilder) {
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(queryParams.from());
		from = criteriaQuery.from(queryParams.from());
		criteriaQuery.select(from);
		return criteriaQuery;
	}

	// Predicate predicate = criteriaBuilder.equal(root.get(field.getName()), field.getValue());
	// criteriaQuery.where(predicate);
	private void setWhere(CriteriaBuilder criteriaBuilder, Expresion where) {
		if (where != null) {
			criteriaQuery.where(createPredicate(criteriaBuilder, where));
		}
	}

	private Predicate createPredicate(CriteriaBuilder criteriaBuilder, Expresion expresion) {
		String firstArgument = expresion.getFirstArgument().getValue();
		String secondArgument = expresion.getSecondArgument().getValue();
		return criteriaBuilder.equal(from.<String> get(firstArgument), secondArgument);
	}
}
