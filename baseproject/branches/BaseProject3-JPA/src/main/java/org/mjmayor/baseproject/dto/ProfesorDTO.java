package org.mjmayor.baseproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.mjmayor.baseproject.constants.AlumnoConstants;
import org.mjmayor.baseproject.constants.ProfesorConstants;

@Entity
@Table(name = ProfesorConstants.Database.TABLE_NAME)
public class ProfesorDTO {

	@Id
	// @Column(name="id")
	@GenericGenerator(name = AlumnoConstants.Database.SERIAL_ID_LABEL, strategy = AlumnoConstants.Database.SERIAL_ID_STRAGEGY)
	@GeneratedValue(generator = AlumnoConstants.Database.SERIAL_ID_LABEL)
	private int id;

	// @Column(name="dni")
	private String dni;

	// @Column(name="nombre")
	private String nombre;

	// @Column(name="apellidos")
	private String apellidos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
