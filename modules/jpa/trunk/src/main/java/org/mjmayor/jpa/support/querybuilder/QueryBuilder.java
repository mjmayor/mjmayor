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
public class QueryBuilder {

	private static CriteriaBuilder criteriaBuilder;

	private Root<?> from;

	public QueryBuilder(CriteriaBuilder criteriaBuilder) {
		QueryBuilder.criteriaBuilder = criteriaBuilder;
	}

	public <T> CriteriaQuery<T> query(QueryParams<T> queryParams) {
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(queryParams.from());
		this.from = criteriaQuery.from(queryParams.from());
		setQueryParams(criteriaQuery, queryParams);
		return criteriaQuery;
	}

	public <T> CriteriaQuery<Long> count(QueryParams<T> queryParams) {
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		this.from = criteriaQuery.from(queryParams.from());
		criteriaQuery.select(criteriaBuilder.count(from));
		setQueryParams(criteriaQuery, queryParams);
		return criteriaQuery;
	}

	private CriteriaQuery<?> setQueryParams(CriteriaQuery<?> criteriaQuery, QueryParams<?> queryParams) {
		setWhere(criteriaQuery, queryParams.where());
		setOrderBy(criteriaQuery, queryParams.orderBy());
		return criteriaQuery;
	}

	// Predicate predicate = criteriaBuilder.equal(root.get(field.getName()), field.getValue());
	// criteriaQuery.where(predicate);
	private void setWhere(CriteriaQuery<?> criteriaQuery, Expresion expresion) {
		if (expresion != null) {
			criteriaQuery.where(createPredicate(expresion));
		}
	}
	
	private Predicate createPredicate(Expresion expresion){
		String firstArgument = expresion.getFirstArgument().getValue();
		String secondArgument = expresion.getSecondArgument().getValue();
		return criteriaBuilder.equal(from.get(firstArgument), secondArgument);
	}

	private void setOrderBy(CriteriaQuery<?> criteriaQuery, List<OrderField> orders) {
		if (orders != null && orders.size() > 1) {
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
}
