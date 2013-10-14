package org.mjmayor.jpa.support;

/**
 * Clase para representar la ordenacion por un campo de una tabla
 * 
 * @author Manuel Jose Mayor Perez
 * @date 14/10/2013
 */
public class OrderField {

	private static final OrderType DEFAULT_ORDER = OrderType.DESC;

	private String name;

	private OrderType order;

	public OrderField(String name, OrderType order) {
		this.name = name;
		this.order = order;
	}

	public OrderField(String name) {
		this.name = name;
		this.order = DEFAULT_ORDER;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
}
