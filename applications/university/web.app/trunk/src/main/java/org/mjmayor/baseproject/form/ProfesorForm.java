package org.mjmayor.baseproject.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.mjmayor.validations.dni.CheckDNILetter;
import org.mjmayor.validations.dni.constants.DNI;

public class ProfesorForm {

	@NotEmpty
	@Pattern(regexp = DNI.PATTERN)
	@CheckDNILetter
	private String dni;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellidos;

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
