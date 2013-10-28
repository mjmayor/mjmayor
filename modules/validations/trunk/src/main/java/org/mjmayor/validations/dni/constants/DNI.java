package org.mjmayor.validations.dni.constants;

/**
 * Constantes usadas para validaciones de DNI
 * 
 * @author Manuel Jose Mayor Perez
 * @date 22/06/2013
 */
public class DNI {
	public static final String PATTERN = "[0-9]{8}[A-Za-z]";
	public static final String DEFAULT_MESSAGE = "Error en la validacion del DNI";
}
