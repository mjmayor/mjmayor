package org.mjmayor.baseproject.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.mjmayor.baseproject.constants.AlumnoConstants;
import org.mjmayor.jpa.dto.PersistentObject;

@Entity
@Table(name = AlumnoConstants.Database.TABLE_NAME)
public class AlumnoDTO extends PersistentObject {

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
