package org.mjmayor.baseproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.mjmayor.baseproject.constants.AlumnoConstants;
import org.mjmayor.baseproject.constants.AsignaturaConstants;

@Entity
@Table(name = AsignaturaConstants.Database.TABLE_NAME)
public class AsignaturaDTO {

	@Id
	// @Column(name="id")
	@GenericGenerator(name = AlumnoConstants.Database.SERIAL_ID_LABEL, strategy = AlumnoConstants.Database.SERIAL_ID_STRAGEGY)
	@GeneratedValue(generator = AlumnoConstants.Database.SERIAL_ID_LABEL)
	private int id;

	// @Column(name="codigo")
	private String codigo;

	// @Column(name="nombre")
	private String nombre;

	// @Column(name="curso")
	private int curso;

	// @Column(name="creditos")
	private Float creditos;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
