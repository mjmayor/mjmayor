package org.mjmayor.baseproject.form;

import org.hibernate.validator.constraints.NotEmpty;

public class ProfesorForm {

	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellidos;
	
	
	public ProfesorForm(){
		nombre=apellidos="";
	}
	
	
	public ProfesorForm(String nombre, String apellidos){
		this.nombre=nombre;
		this.apellidos=apellidos;
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
