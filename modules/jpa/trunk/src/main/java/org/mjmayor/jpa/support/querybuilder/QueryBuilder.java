package org.mjmayor.jpa.support.querybuilder;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
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

	private CriteriaBuilder criteriaBuilder;

	public QueryBuilder(QueryParams<T> queryParams) {
		this.queryParams = queryParams;
	}

	public CriteriaQuery<T> query(CriteriaBuilder criteriaBuilder) {
		this.criteriaBuilder = criteriaBuilder;
		criteriaQuery = createCriteriaQuery();
		setWhere(queryParams.where());
		setOrderBy(queryParams.orderBy());
		return criteriaQuery;
	}

	private CriteriaQuery<T> createCriteriaQuery() {
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(queryParams.from());
		from = criteriaQuery.from(queryParams.from());
		criteriaQuery.select(from);
		return criteriaQuery;
	}

	// Predicate predicate = criteriaBuilder.equal(root.get(field.getName()), field.getValue());
	// criteriaQuery.where(predicate);
	private void setWhere(Expresion where) {
		if (where != null) {
			criteriaQuery.where(createPredicate(where));
		}
	}

	private Predicate createPredicate(Expresion expresion) {
		String firstArgument = expresion.getFirstArgument().getValue();
		String secondArgument = expresion.getSecondArgument().getValue();
		return criteriaBuilder.equal(from.get(firstArgument), secondArgument);
	}

	private void setOrderBy(List<OrderField> orders) {
		List<Order> criteriaOrder = new ArrayList<Order>();
		for (OrderField order : orders) {
			if (order.isAscending()) {
				criteriaOrder.add(criteriaBuilder.asc(from.get(order.getName())));
			} else {
				criteriaOrder.add(criteriaBuilder.desc(from.get(order.getName())));
			}
		}
		criteriaQuery.orderBy(criteriaOrder);
	}
}
