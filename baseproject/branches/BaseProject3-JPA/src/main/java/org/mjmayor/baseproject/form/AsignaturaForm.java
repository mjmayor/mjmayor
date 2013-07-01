package org.mjmayor.baseproject.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class AsignaturaForm {

	@NotEmpty
	private String codigo;

	@NotEmpty
	private String nombre;

	@Range(min = 1, max = 5)
	private int curso;

	@NotNull
	private Float creditos;

	public AsignaturaForm() {

	}

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
