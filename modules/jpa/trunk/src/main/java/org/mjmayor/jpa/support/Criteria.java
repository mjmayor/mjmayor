package org.mjmayor.jpa.support;

import java.util.Date;

/**
 * Criterios para las consultas de BBDD
 * 
 * @author Manuel Jose Mayor Perez
 * @date 24/07/2013
 */
public class Criteria {

	public static final OrderType DEFAULT_ORDER = OrderType.DESC;

	/**
	 * Fecha desde
	 */
	private Date from;

	/**
	 * Fecha hasta
	 */
	private Date to;

	/**
	 * Orden de los resultados a devolver
	 */
	private OrderType order;

	/**
	 * Parametros para paginacion
	 */
	private PageRequest pageRequest;

	/**
	 * Constructor <br/>
	 * 
	 * Orden descendente por defecto
	 */
	public Criteria() {
		order = DEFAULT_ORDER;
	}

	/**
	 * @return the from
	 */
	public Date getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(Date from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public Date getTo() {
		return to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(Date to) {
		this.to = to;
	}

	/**
	 * @return the order
	 */
	public OrderType getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(OrderType order) {
		this.order = order;
	}

	/**
	 * @return the pageRequest
	 */
	public PageRequest getPageRequest() {
		return pageRequest;
	}

	/**
	 * @param pageRequest
	 *            the pageRequest to set
	 */
	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}

	public boolean isDateAssigned() {
		return from != null || to != null;
	}
}
