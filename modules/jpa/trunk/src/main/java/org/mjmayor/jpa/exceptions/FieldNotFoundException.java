package org.mjmayor.jpa.exceptions;

/**
 * Excepcion para lanzarse en caso de que haya algun error en alguna escritura en base de datos
 * 
 * @author Manuel Jose Mayor Perez
 * @date 11/07/2013
 */
public class FieldNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7927485522913367165L;

	public FieldNotFoundException() {
		super("");
	}

	public FieldNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FieldNotFoundException(String arg0) {
		super(arg0);
	}

	public FieldNotFoundException(Throwable t) {
		super(t);
	}
}
