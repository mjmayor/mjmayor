package org.mjmayor.jpa.support.querybuilder;

public class Expresion {

	private Object firstArgument;

	private Operator operator;

	private Object secondArgument;

	public Expresion(Object firstArgument, Operator operator, Object secondArgument) {
		this.firstArgument = firstArgument;
		this.operator = operator;
		this.secondArgument = secondArgument;
	}

	/**
	 * @return the firstArgument
	 */
	public Object getFirstArgument() {
		return firstArgument;
	}

	/**
	 * @param firstArgument
	 *            the firstArgument to set
	 */
	public void setFirstArgument(Object firstArgument) {
		this.firstArgument = firstArgument;
	}

	/**
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	/**
	 * @return the secondArgument
	 */
	public Object getSecondArgument() {
		return secondArgument;
	}

	/**
	 * @param secondArgument
	 *            the secondArgument to set
	 */
	public void setSecondArgument(Object secondArgument) {
		this.secondArgument = secondArgument;
	}
}
