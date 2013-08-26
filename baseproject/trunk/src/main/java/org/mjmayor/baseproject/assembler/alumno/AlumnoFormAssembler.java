package org.mjmayor.baseproject.assembler.alumno;

import org.mjmayor.baseproject.entity.Alumno;
import org.mjmayor.baseproject.form.AlumnoForm;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.springframework.beans.BeanUtils;

public class AlumnoFormAssembler extends AbstractAssembler<AlumnoForm, Alumno> {

	@Override
	public Alumno assemble(AlumnoForm alumnoForm) {
		Alumno alumnoDTO = new Alumno();
		BeanUtils.copyProperties(alumnoForm, alumnoDTO);
		return alumnoDTO;
	}
}
