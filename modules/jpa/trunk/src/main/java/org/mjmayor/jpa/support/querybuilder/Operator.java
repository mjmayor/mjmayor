package org.mjmayor.jpa.support.querybuilder;

public enum Operator {

	EQ("equal"), NE("notEqual"), LIKE("like"), IN("in"), BETWEEN("between"), GT("gt"), LT("lt"), GE("ge"), LE("le");

	private String type;

	private Operator(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}