package org.mjmayor.jpa.support.querybuilder;

/**
 * Enumerado para el tipo de ordenacion
 * 
 * @author Manuel Jose Mayor Perez
 * @date 20/08/2013
 */
public enum OrderType {
	ASC("ASC"), DESC("DESC");

	private String type;

	private OrderType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
