package org.mjmayor.baseproject.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mjmayor.baseproject.annotations.CheckDNI;

public class AlumnoForm {
	
	@NotEmpty
	@Pattern(regexp = "[0-9]{8}[A-Za-z]")
	@CheckDNI
	private String dni;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellidos;
	
	@Email
	private String email;
	
	
	public AlumnoForm(){
		dni=nombre=apellidos=email="";
	}
	
	
	public AlumnoForm(String dni, String nombre,
				  String apellidos, String email){
		
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.email=email;
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
