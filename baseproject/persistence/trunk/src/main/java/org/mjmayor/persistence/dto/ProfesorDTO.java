package org.mjmayor.persistence.dto;

import java.io.Serializable;

public class ProfesorDTO implements Serializable {

	private static final long serialVersionUID = -6712798672299387870L;

	private String dni;

	private String nombre;

	private String apellidos;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
