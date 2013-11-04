package org.mjmayor.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.mjmayor.jpa.entity.PersistentObject;

@Entity
public class Alumno extends PersistentObject {

	private static final long serialVersionUID = -3496768348923866510L;

	@NotNull
	private String dni;

	@NotNull
	private String nombre;

	@NotNull
	private String apellidos;

	@NotNull
	private Date fechaNacimiento;

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

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
