package org.mjmayor.model.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.mjmayor.jpa.entity.PersistentObject;

@Entity
public class Profesor extends PersistentObject {

	private static final long serialVersionUID = -6712798672299387870L;

	@NotNull
	private String dni;

	@NotNull
	private String nombre;

	@NotNull
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
