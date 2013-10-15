package org.mjmayor.jpa.support.querybuilder;

public enum Like {

	PERCENT_BEFORE("PERCENT_BEFORE"), PERCENT_AFTER("PERCENT_AFTER"), PERCENT_AROUND("PERCENT_AROUND");

	private String type;

	private Like(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
