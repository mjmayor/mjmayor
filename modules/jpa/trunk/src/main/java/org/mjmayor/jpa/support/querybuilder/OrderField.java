package org.mjmayor.jpa.support.querybuilder;

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

	public boolean isAscending() {
		return order.equals(OrderType.ASC);
	}
}
