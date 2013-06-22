package org.mjmayor.baseproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mjmayor.baseproject.annotations.CheckDNI;

@Entity
// @Table(name="alumno",schema="mjmayor3")
public class AlumnoDTO {

    @Id
    // @Column(name="id")
    @GenericGenerator(name = "serial_id_alumno", strategy = "increment")
    @GeneratedValue(generator = "serial_id_alumno")
    private int id;

    // @Column(name="dni")
    private String dni;

    // @Column(name="nombre")
    private String nombre;

    // @Column(name="apellidos")
    private String apellidos;

    // @Column(name="email")
    private String email;

    public AlumnoDTO() {
	dni = nombre = apellidos = email = "";
    }

    public AlumnoDTO(String dni, String nombre, String apellidos, String email) {

	this.dni = dni;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.email = email;
    }

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

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }
}
