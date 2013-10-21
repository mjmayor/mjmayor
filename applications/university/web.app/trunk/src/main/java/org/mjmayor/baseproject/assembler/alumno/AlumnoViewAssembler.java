package org.mjmayor.baseproject.assembler.alumno;

import org.mjmayor.baseproject.view.AlumnoView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.entity.Alumno;

public class AlumnoViewAssembler extends AbstractAssembler<Alumno, AlumnoView> {

	@Override
	public AlumnoView assemble(Alumno source) {
		AlumnoView target = new AlumnoView();
		target.setDni(source.getDni());
		target.setNombreCompleto(source.getApellidos() + ", " + source.getNombre());
		target.setEmail(source.getEmail());
		return target;
	}
}
