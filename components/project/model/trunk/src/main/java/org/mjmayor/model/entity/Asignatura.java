package org.mjmayor.model.entity;

import javax.persistence.Entity;

import org.mjmayor.jpa.entity.PersistentObject;


@Entity
public class Asignatura extends PersistentObject {

	private static final long serialVersionUID = 5193440247827673686L;

	private String codigo;

	private String nombre;

	private int curso;

	private Float creditos;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return the curso
	 */
	public int getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(int curso) {
		this.curso = curso;
	}

	/**
	 * @return the creditos
	 */
	public Float getCreditos() {
		return creditos;
	}

	/**
	 * @param creditos
	 *            the creditos to set
	 */
	public void setCreditos(Float creditos) {
		this.creditos = creditos;
	}
}
