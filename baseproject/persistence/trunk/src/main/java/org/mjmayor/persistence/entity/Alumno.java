package org.mjmayor.persistence.entity;

import javax.persistence.Entity;

import org.mjmayor.jpa.entity.PersistentObject;

@Entity
public class Alumno extends PersistentObject {

	private static final long serialVersionUID = -3496768348923866510L;

	private String dni;

	private String nombre;

	private String apellidos;

	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
