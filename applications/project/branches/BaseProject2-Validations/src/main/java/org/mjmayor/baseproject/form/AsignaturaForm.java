package org.mjmayor.baseproject.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class AsignaturaForm {

	@NotEmpty
	private String nombre;
	
	@Range(min=1, max=5)
	private int curso;
	
	@NotNull
	private Float creditos;
	
	
	public AsignaturaForm(){
		
	}
	
	
	public AsignaturaForm(String nombre, int curso, float creditos){
		this.nombre=nombre;
		this.curso=curso;
		this.creditos=creditos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCurso() {
		return curso;
	}


	public void setCurso(int curso) {
		this.curso = curso;
	}


	public Float getCreditos() {
		return creditos;
	}


	public void setCreditos(Float creditos) {
		this.creditos = creditos;
	}
}
