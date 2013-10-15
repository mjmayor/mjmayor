package org.mjmayor.jpa.support.querybuilder;

public enum Operator {

	LIKE("LIKE"), IN("IN"), BETWEEN("BETWEEN"), NE("NE"), GT("GT"), LT("LT"), GE("GE"), LE("LE");

	private String type;

	private Operator(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}