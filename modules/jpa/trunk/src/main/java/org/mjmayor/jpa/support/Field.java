package org.mjmayor.jpa.support;

/**
 * Clase para representar un campo de una tabla
 * 
 * @author Manuel Jose Mayor Perez
 * @date 14/10/2013
 */
public class Field {

	/**
	 * Nombre del campo
	 */
	private String name;

	/**
	 * Valor del campo
	 */
	private Object value;

	public Field(String name, Object value) {
		this.name = name;
		this.value = value;
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
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
