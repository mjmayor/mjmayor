package org.mjmayor.jpa.support.querybuilder;

public class Expresion {

	private Argument firstArgument;

	private Operator operator;

	private Argument secondArgument;

	public Expresion(Argument firstArgument, Operator operator, Argument secondArgument) {
		this.firstArgument = firstArgument;
		this.operator = operator;
		this.secondArgument = secondArgument;
	}

	public Expresion(Argument firstArgument, Operator operator, Object secondArgument) {
		this.firstArgument = firstArgument;
		this.operator = operator;
		this.secondArgument = new Argument(secondArgument);
	}

	public Expresion(Object firstArgument, Operator operator, Argument secondArgument) {
		this.firstArgument = new Argument(firstArgument);
		this.operator = operator;
		this.secondArgument = secondArgument;
	}

	public Expresion(Object firstArgument, Operator operator, Object secondArgument) {
		this.firstArgument = new Argument(firstArgument);
		this.operator = operator;
		this.secondArgument = new Argument(secondArgument);
	}

	/**
	 * @return the firstArgument
	 */
	public Argument getFirstArgument() {
		return firstArgument;
	}

	/**
	 * @param firstArgument
	 *            the firstArgument to set
	 */
	public void setFirstArgument(Argument firstArgument) {
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
	public Argument getSecondArgument() {
		return secondArgument;
	}

	/**
	 * @param secondArgument
	 *            the secondArgument to set
	 */
	public void setSecondArgument(Argument secondArgument) {
		this.secondArgument = secondArgument;
	}
}
