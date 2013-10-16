package org.mjmayor.jpa.support.querybuilder;

import java.util.List;

/**
 * Clase que almacena los parametros de la query
 * 
 * @author Manuel Jose Mayor Perez
 * @date 15/10/2013
 */
public class QueryParams<T> {

	public QueryParams(Class<T> from) {
		this.from = from;
	}

	/**
	 * Clase a la que se accedera en la consulta
	 */
	private Class<T> from;

	/**
	 * Condiciones de la clausula where
	 */
	private Expresion where;

	/**
	 * Parametros para la clausula orderBy
	 */
	private List<OrderField> orderBy;

	private Object groupBy;

	private Object having;

	/**
	 * @return the from
	 */
	public Class<T> from() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void from(Class<T> from) {
		this.from = from;
	}

	/**
	 * @return the where
	 */
	public Expresion where() {
		return where;
	}

	/**
	 * @param where
	 *            the where to set
	 */
	public void where(Expresion where) {
		this.where = where;
	}

	/**
	 * @return the orderBy
	 */
	public List<OrderField> orderBy() {
		return orderBy;
	}

	/**
	 * @param orderBy
	 *            the orderBy to set
	 */
	public void orderBy(List<OrderField> orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * @return the groupBy
	 */
	public Object groupBy() {
		return groupBy;
	}

	/**
	 * @param groupBy
	 *            the groupBy to set
	 */
	public void groupBy(Object groupBy) {
		this.groupBy = groupBy;
	}

	/**
	 * @return the having
	 */
	public Object having() {
		return having;
	}

	/**
	 * @param having
	 *            the having to set
	 */
	public void having(Object having) {
		this.having = having;
	}
}
