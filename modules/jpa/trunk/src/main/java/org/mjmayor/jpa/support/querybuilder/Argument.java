package org.mjmayor.jpa.support.querybuilder;

public class Argument {

	private Object value;

	public Argument(Object value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	@SuppressWarnings("unchecked")
	public <T> T getValue() {
		if (value instanceof String) {
			return (T) (String) value;
		}
		return null;
	}

	public boolean isFinalValue() {
		return (value instanceof String || value instanceof Long || value instanceof Double);
	}
}
