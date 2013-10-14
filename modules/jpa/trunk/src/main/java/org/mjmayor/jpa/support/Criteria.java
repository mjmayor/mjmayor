package org.mjmayor.jpa.support;

import java.util.Date;
import java.util.List;

/**
 * Criterios para las consultas de BBDD
 * 
 * @author Manuel Jose Mayor Perez
 * @date 24/07/2013
 */
public class Criteria {

	/**
	 * Parametros para paginacion
	 */
	private PageRequest pageRequest;

	/**
	 * Lista de campos por los que ordenar
	 */
	private List<OrderField> orderFields;

	/**
	 * Fecha desde
	 */
	private Date from;

	/**
	 * Fecha hasta
	 */
	private Date to;

	/**
	 * Constructor <br/>
	 * 
	 * Orden descendente por defecto
	 */
	public Criteria() {
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

	/**
	 * @return the orderFields
	 */
	public List<OrderField> getOrderFields() {
		return orderFields;
	}

	/**
	 * @param orderFields
	 *            the orderFields to set
	 */
	public void setOrderFields(List<OrderField> orderFields) {
		this.orderFields = orderFields;
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

	public boolean isDateAssigned() {
		return from != null || to != null;
	}
}
